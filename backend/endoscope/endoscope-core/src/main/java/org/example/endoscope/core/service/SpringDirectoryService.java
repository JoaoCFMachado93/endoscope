package org.example.endoscope.core.service;

import jakarta.transaction.Transactional;
import org.example.endoscope.core.domain.Directory;
import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driver.DirectoryServicePort;

import java.util.List;

public class SpringDirectoryService implements DirectoryServicePort {

    private final DirectoryRepositoryPort directoryRepositoryPort;

    public SpringDirectoryService(DirectoryRepositoryPort directoryRepositoryPort) {
        this.directoryRepositoryPort = directoryRepositoryPort;
    }

    @Override
    public List<Directory> getDirectories() {
        return directoryRepositoryPort.getDirectories();
    }

    @Override
    @Transactional
    public void createDirectory(List<Directory> directories) {
        if (directories.isEmpty()) {
            return;
        }

        directoryRepositoryPort.createDirectories(directories);
    }

    @Override
    public Directory getDirectoryById(long directoryId) {
        if (!directoryRepositoryPort.doesDirectoryExist(directoryId)) {
            throw new IllegalArgumentException("Directory does not exist");
        }

        return directoryRepositoryPort.getDirectoryById(directoryId);
    }

    @Override
    @Transactional
    public void editDirectory(long directoryId, String directoryName, Integer directoryPosition) {
        if (!directoryRepositoryPort.doesDirectoryExist(directoryId)) {
            throw new IllegalArgumentException("Directory does not exist");
        }

        directoryRepositoryPort.editDirectory(directoryId, directoryName, directoryPosition);
    }

    @Override
    @Transactional
    public void deleteDirectory(long directoryId) {
        directoryRepositoryPort.deleteDirectory(directoryId);
    }

    @Override
    public List<Directory> getSubDirectories(long directoryId) {
        return directoryRepositoryPort.getSubDirectories(directoryId);
    }

    @Override
    @Transactional
    public void createSubDirectory(List<Directory> subDirectories) {
        if (subDirectories.isEmpty()) {
            return;
        }

        directoryRepositoryPort.createSubDirectories(subDirectories);
    }

    @Override
    @Transactional
    public void addOrEditDirectoryDescription(Long directoryId, String description) {
        directoryRepositoryPort.addOrEditDirectoryDescription(directoryId, description);

    }
}

