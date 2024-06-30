package org.example.endoscope.core.driven;

import org.example.endoscope.core.domain.Image;

import java.util.List;

public interface ImageRepositoryPort {

    void createImageInDirectory(long directoryId, List<Image> image);

    Image getImageById(long imageId);

    List<Image> getImagesByDirectoryId(long directoryId);

    void deleteImage(long imageId);

    void deleteAllImagesInDirectory(long directoryId);

    void editImageDescription(Long imageId, String description);

    List<Image> findAll();

    void saveAll(List<Image> images);
}
