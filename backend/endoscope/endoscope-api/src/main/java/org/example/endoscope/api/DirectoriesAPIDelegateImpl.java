package org.example.endoscope.api;


import lombok.extern.slf4j.Slf4j;
import org.example.endoscope.api.mapper.directory.DirectoryConverter;
import org.example.endoscope.api.openapi.DirectoryApiDelegate;
import org.example.endoscope.api.openapi.model.DirectoryDescriptionUpsert;
import org.example.endoscope.api.openapi.model.DirectoryEntity;
import org.example.endoscope.api.openapi.model.DirectoryEntityUpdate;
import org.example.endoscope.core.driver.DirectoryServicePort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class DirectoriesAPIDelegateImpl implements DirectoryApiDelegate {

    private final DirectoryServicePort directoryServicePort;
    private final DirectoryConverter directoryConverter;

    public DirectoriesAPIDelegateImpl(DirectoryServicePort directoryServicePort, DirectoryConverter directoryConverter) {
        this.directoryServicePort = directoryServicePort;
        this.directoryConverter = directoryConverter;
    }

    @Override
    public ResponseEntity<List<DirectoryEntity>> getDirectories() {
        log.info("Fetching directories");
        var directories = directoryServicePort.getDirectories();

        return ResponseEntity.ok(directories.stream()
                .map(directoryConverter::domainToDto)
                .toList());
    }

    @Override
    public ResponseEntity<Void> createDirectory(List<DirectoryEntity> directoryEntity) {
        log.info("Creating the following directories: {}", directoryEntity);
        var directoryDomainList = directoryEntity.stream()
                .map(directoryConverter::dtoToDomain)
                .toList();

        directoryServicePort.createDirectory(directoryDomainList);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<DirectoryEntity> getDirectoryById(Integer directoryId) {
        log.info("Fetching directory by id: {}", directoryId);
        var directory = directoryServicePort.getDirectoryById(directoryId);
        return ResponseEntity.ok(directoryConverter.domainToDto(directory));
    }

    @Override
    public ResponseEntity<Void> editDirectory(Integer directoryId, DirectoryEntityUpdate directoryEntityUpdate) {
        log.info("Editing directory by id: {}", directoryId);
        directoryServicePort.editDirectory(directoryId, directoryEntityUpdate.getDirectoryName(),
                directoryEntityUpdate.getDirectoryPosition());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteDirectory(Integer directoryId) {
        log.info("Deleting directory by id: {}", directoryId);
        directoryServicePort.deleteDirectory(directoryId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<DirectoryEntity>> getSubDirectories(Integer directoryId) {
        log.info("Fetching sub directories");
        var subDirectories = directoryServicePort.getSubDirectories(directoryId);

        return ResponseEntity.ok(subDirectories.stream()
                .map(directoryConverter::domainToDto)
                .toList());
    }

    @Override
    public ResponseEntity<Void> createSubDirectory(Integer directoryId, List<DirectoryEntity> subDirectoryEntity) {
        log.info("Creating the following sub directories: {}", subDirectoryEntity);
        var subDirectoryDomainList = subDirectoryEntity.stream()
                .map(directoryConverter::dtoToDomain)
                .toList();

        directoryServicePort.createSubDirectory(subDirectoryDomainList);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> addOrEditDirectoryDescription(DirectoryDescriptionUpsert directoryDescriptionUpsert) {
        log.info("Adding or editing directory description: {}", directoryDescriptionUpsert);
        Long directoryId = directoryDescriptionUpsert.getDirectoryId();
        String description = directoryDescriptionUpsert.getDescription();
        directoryServicePort.addOrEditDirectoryDescription(directoryId, description);
        return ResponseEntity.ok().build();
    }
}
