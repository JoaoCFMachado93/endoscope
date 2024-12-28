package org.example.endoscope.core.driver;

import org.example.endoscope.core.domain.Image;

import java.util.List;

public interface ImageServicePort {

    void createImageInDirectory(long directoryId, List<Image> image);

    Image getImageById(long imageId);

    List<Image> getImagesByDirectoryId(long directoryId);

    void deleteImage(long imageId);

    void editImageDescription(Long imageId, String description);

    void updateImageState(long imageId, String state);
}
