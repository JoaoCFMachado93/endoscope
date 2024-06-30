package org.example.endoscope.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.endoscope.core.domain.Directory;
import org.example.endoscope.core.domain.Image;
import org.example.endoscope.core.domain.User;
import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.core.driven.UserRepositoryPort;
import org.example.endoscope.core.driver.BackupServicePort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class BackupService implements BackupServicePort {

    private final DirectoryRepositoryPort directoryRepository;
    private final ImageRepositoryPort imageRepository;
    private final UserRepositoryPort userRepository;
    private final ObjectMapper objectMapper;
    private final String backupDirectory;

    public BackupService(DirectoryRepositoryPort directoryRepository,
                         ImageRepositoryPort imageRepository,
                         UserRepositoryPort userRepository) {
        this.directoryRepository = directoryRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;

        this.objectMapper = new ObjectMapper();
        // Register the JavaTimeModule
        this.objectMapper.registerModule(new JavaTimeModule());

        // Use the application's working directory for storing backups
        this.backupDirectory = Paths.get(System.getProperty("user.dir"), "backup").toString();
//        createBackupDirectoryIfNotExists(); //COMMENT THIS FOR PROD Deploys
    }

    private void createBackupDirectoryIfNotExists() {
        File dir = new File(backupDirectory);
        if (!dir.exists()) {
            boolean result = dir.mkdirs();
            if (!result) {
                throw new RuntimeException("Failed to create backup directory: " + backupDirectory);
            }
        }
    }

    @Override
    @Transactional
    public void createBackup() {
        try {
            List<Directory> directories = directoryRepository.findAll();
            List<Image> images = imageRepository.findAll();
            List<User> users = userRepository.findAll();

            // Serialize entities to files
            objectMapper.writeValue(new File(backupDirectory, "directories.json"), directories);
            objectMapper.writeValue(new File(backupDirectory, "images.json"), images);
            objectMapper.writeValue(new File(backupDirectory, "users.json"), users);

            log.info("Backup created successfully");
        } catch (IOException e) {
            log.error("Failed to create backup", e);
            throw new RuntimeException("Failed to create backup", e);
        }
    }

    @Override
    @Transactional
    public void restoreBackup() {
        try {
            List<Directory> directories = objectMapper.readValue(new File(backupDirectory, "directories.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Directory.class));
            List<Image> images = objectMapper.readValue(new File(backupDirectory, "images.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Image.class));
            List<User> users = objectMapper.readValue(new File(backupDirectory, "users.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));

            userRepository.saveAll(users);

            // Step 1: Save directories without parent references
            Map<Long, Long> idMapping = new HashMap<>();
            List<Directory> savedDirectories = directoryRepository.saveAll(directories, idMapping);

            // Step 2: Update parent directories
            List<Directory> updatedDirectories = savedDirectories.stream()
                    .map(savedDirectory -> {
                        Directory finalSavedDirectory = savedDirectory;
                        Directory originalDirectory = directories.stream()
                                .filter(dir -> idMapping.get(dir.getDirectoryId()).equals(finalSavedDirectory.getDirectoryId()))
                                .findFirst()
                                .orElse(null);

                        if (originalDirectory != null && originalDirectory.getParentDirectory() != 0) {
                            Long newParentId = idMapping.get(originalDirectory.getParentDirectory());

                            if (newParentId == null) {
                                newParentId = 6l; //CHANGE HERE FOR BASE DIRECTORY ID
                            }
                            savedDirectory = savedDirectory.toBuilder().parentDirectory(newParentId).build();

                        }
                        return savedDirectory;
                    })
                    .toList();

            // Step 3: Save directories with updated parent references
            directoryRepository.updateAll(updatedDirectories);

            // Step 4: Restore images with the correct directory IDs
            List<Image> updatedImages = images.stream()
                    .map(image -> image.toBuilder()
                            .directory(idMapping.get(image.getDirectory()))
                            .build())
                    .collect(Collectors.toList());

            imageRepository.saveAll(updatedImages);

            log.info("Backup restored successfully");
        } catch (IOException e) {
            log.error("Failed to restore backup", e);
            throw new RuntimeException("Failed to restore backup", e);
        }
    }


}