package org.example.endoscope.output.adapter;

import org.example.endoscope.core.domain.Directory;
import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.output.dbo.DirectoryEntity;
import org.example.endoscope.output.mapper.directory.DbDirectoryConverter;
import org.example.endoscope.output.repository.DirectoryJpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DirectoryRepository implements DirectoryRepositoryPort {

    private final DirectoryJpaRepository directoryJpaRepository;
    private final DbDirectoryConverter dbDirectoryConverter;
    private final ImageRepositoryPort imageRepositoryPort;

    public DirectoryRepository(
            DirectoryJpaRepository directoryJpaRepository,
            DbDirectoryConverter dbDirectoryConverter,
            ImageRepositoryPort imageRepositoryPort) {
        this.directoryJpaRepository = directoryJpaRepository;
        this.dbDirectoryConverter = dbDirectoryConverter;
        this.imageRepositoryPort = imageRepositoryPort;
    }

    @Override
    public boolean doesDirectoryExist(long directoryId) {
        return directoryJpaRepository.existsById(directoryId);
    }

    @Override
    public List<Directory> getDirectories() {
        return directoryJpaRepository.findByParentDirectoryIsNull().stream()
                .map(dbDirectoryConverter::dboToDomain)
                .toList();
    }

    @Override
    public void createDirectories(List<Directory> directories) {
        List<DirectoryEntity> directoryEntityList = directories.stream()
                .map(dbDirectoryConverter::domainToDbo)
                .peek(directoryEntity -> directoryEntity.setParentDirectory(null))
                .peek(directoryEntity -> directoryEntity.setDirectoryPosition(1))
                .toList();

        directoryJpaRepository.saveAll(directoryEntityList);
    }

    @Override
    public Directory getDirectoryById(long directoryId) {
        return directoryJpaRepository.findById(directoryId)
                .map(dbDirectoryConverter::dboToDomain)
                .orElse(null);
    }

    @Override
    public void editDirectory(long directoryId, String directoryName, Integer directoryPosition) {
        directoryJpaRepository.findById(directoryId)
                .ifPresent(directoryEntity -> {
                    directoryEntity.setDirectoryName(directoryName);
                    directoryEntity.setDirectoryPosition(directoryPosition);
                    directoryJpaRepository.save(directoryEntity);
                });
    }

    @Override
    public void deleteDirectory(long directoryId) {
        DirectoryEntity directoryEntity = directoryJpaRepository.findById(directoryId)
                .orElseThrow(() -> new IllegalArgumentException("Directory not found"));

        // Delete subdirectories recursively and their associated images
        deleteSubdirectoriesAndImages(directoryEntity.getDirectoryId());
        // Delete images directly associated with this directory
        imageRepositoryPort.deleteAllImagesInDirectory(directoryId);
        // Finally, delete the main directory
        directoryJpaRepository.delete(directoryEntity);
    }

    private void deleteSubdirectoriesAndImages(Long directoryId) {
        Set<Long> subdirectoryIds = directoryJpaRepository.findByParentDirectory_DirectoryId(directoryId).stream()
                .map(DirectoryEntity::getDirectoryId)
                .collect(Collectors.toSet());

        for (Long subdirectoryId : subdirectoryIds) {
            deleteSubdirectoriesAndImages(subdirectoryId); // Recursively delete subdirectories
            imageRepositoryPort.deleteAllImagesInDirectory(subdirectoryId); // Delete images in subdirectory
            directoryJpaRepository.deleteById(subdirectoryId); // Delete the subdirectory itself
        }
    }

    @Override
    public List<Directory> getSubDirectories(long directoryId) {
        return directoryJpaRepository.findByParentDirectory_DirectoryId(directoryId).stream()
                .map(dbDirectoryConverter::dboToDomain)
                .toList();
    }

    @Override
    public void createSubDirectories(List<Directory> directories) {
        List<DirectoryEntity> subDirectoryEntityList = directories.stream()
                .map(dbDirectoryConverter::domainToDbo)
                .peek(directoryEntity -> directoryEntity.setDirectoryDescription(" "))
                .toList();

        directoryJpaRepository.saveAll(subDirectoryEntityList);
    }

    @Override
    public void addOrEditDirectoryDescription(Long directoryId, String description) {
        directoryJpaRepository.findById(directoryId)
                .ifPresent(directoryEntity -> {
                    directoryEntity.setDirectoryDescription(description);
                    directoryJpaRepository.save(directoryEntity);
                });
    }

    @Override
    public int getNumberOfImagesInDirectory(long directoryId) {
        return directoryJpaRepository.findById(directoryId)
                .map(DirectoryEntity::getImageCount)
                .orElse(0);
    }

    @Override
    public void incrementImageCount(long directoryId) {
        directoryJpaRepository.findById(directoryId)
                .ifPresent(directoryEntity -> {
                    directoryEntity.setImageCount(directoryEntity.getImageCount() + 1);
                    directoryJpaRepository.save(directoryEntity);
                });
    }

    @Override
    public void decrementImageCount(long directoryId) {
        directoryJpaRepository.findById(directoryId)
                .ifPresent(directoryEntity -> {
                    directoryEntity.setImageCount(directoryEntity.getImageCount() - 1);
                    directoryJpaRepository.save(directoryEntity);
                });
    }

    @Override
    public int getDirectoryPosition(long directoryId) {
        return directoryJpaRepository.findById(directoryId)
                .map(DirectoryEntity::getDirectoryPosition)
                .orElse(0);
    }

    @Override
    public List<Directory> saveAll(List<Directory> directories, Map<Long, Long> idMapping) {
        List<DirectoryEntity> directoryEntities = directories.stream()
                .map(directory -> {
                    DirectoryEntity directoryEntity = new DirectoryEntity();
                    directoryEntity.setDirectoryName(directory.getDirectoryName());
                    directoryEntity.setDirectoryDescription(directory.getDirectoryDescription());
                    directoryEntity.setImageCount(directory.getImageCount());
                    directoryEntity.setDirectoryPosition(directory.getDirectoryPosition());
                    return directoryEntity;
                })
                .collect(Collectors.toList());

        List<DirectoryEntity> savedEntities = directoryJpaRepository.saveAll(directoryEntities);

        // Update ID mappings after entities are saved and IDs are generated
        for (int i = 0; i < savedEntities.size(); i++) {
            idMapping.put(directories.get(i).getDirectoryId(), savedEntities.get(i).getDirectoryId());
        }

        return savedEntities.stream()
                .map(dbDirectoryConverter::dboToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAll(List<Directory> directories) {
        List<DirectoryEntity> directoryEntities = directories.stream()
                .map(dbDirectoryConverter::domainToDbo)
                .toList();

        directoryJpaRepository.saveAll(directoryEntities);
    }

    @Override
    public List<Directory> findAll() {
        return directoryJpaRepository.findAll().stream()
                .map(dbDirectoryConverter::dboToDomain)
                .collect(Collectors.toList());
    }
}
