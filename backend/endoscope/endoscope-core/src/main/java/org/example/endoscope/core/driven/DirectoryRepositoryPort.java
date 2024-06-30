package org.example.endoscope.core.driven;

import org.example.endoscope.core.domain.Directory;

import java.util.List;
import java.util.Map;

public interface DirectoryRepositoryPort {

    boolean doesDirectoryExist(long directoryId);

    List<Directory> getDirectories();

    void createDirectories(List<Directory> directories);

    List<Directory> getSubDirectories(long directoryId);

    void createSubDirectories(List<Directory> subDirectories);

    void addOrEditDirectoryDescription(Long directory, String description);

    int getNumberOfImagesInDirectory(long directoryId);

    void incrementImageCount(long directoryId);

    void decrementImageCount(long directoryId);


    int getDirectoryPosition(long directoryId);

    Directory getDirectoryById(long directoryId);

    void editDirectory(long directoryId,
                       String directoryName,
                       Integer directoryPosition);

    void deleteDirectory(long directoryId);

    List<Directory> saveAll(List<Directory> directories, Map<Long, Long> idMapping);

    void updateAll(List<Directory> directories);

    List<Directory> findAll();
}
