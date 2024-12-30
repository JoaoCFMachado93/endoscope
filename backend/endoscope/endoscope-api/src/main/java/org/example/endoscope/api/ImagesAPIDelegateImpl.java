package org.example.endoscope.api;


import lombok.extern.slf4j.Slf4j;
import org.example.endoscope.api.mapper.directory.ImageConverter;
import org.example.endoscope.api.openapi.ImageApiDelegate;
import org.example.endoscope.api.openapi.model.ImageDescriptionUpsert;
import org.example.endoscope.api.openapi.model.ImageEntity;
import org.example.endoscope.api.openapi.model.UpdateImageStateRequest;
import org.example.endoscope.core.driver.ImageServicePort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class ImagesAPIDelegateImpl implements ImageApiDelegate {

    private final ImageServicePort imageServicePort;
    private final ImageConverter imageConverter;

    public ImagesAPIDelegateImpl(ImageServicePort imageServicePort, ImageConverter imageConverter) {
        this.imageServicePort = imageServicePort;
        this.imageConverter = imageConverter;
    }

    @Override
    public ResponseEntity<Void> createImageInDirectory(Integer directoryId, List<ImageEntity> imageEntity) {
        log.info("Creating the following images in directory: {}", imageEntity);
        var imageDomainList = imageEntity.stream()
                .map(imageConverter::dtoToDomain)
                .toList();
        imageServicePort.createImageInDirectory(directoryId, imageDomainList);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ImageEntity> getImageById(Integer imageId) {
        log.info("Fetching image by id: {}", imageId);
        var image = imageServicePort.getImageById(imageId);
        return ResponseEntity.ok(imageConverter.domainToDto(image));
    }

    @Override
    public ResponseEntity<List<ImageEntity>> getImagesByDirectoryId(Integer directoryId) {
        log.info("Fetching images by directory id: {}", directoryId);

        var images = imageServicePort.getImagesByDirectoryId(directoryId);

        var filteredImages = images.stream()
                .filter(image -> !image.getState().equals("DENIED"))
                .map(imageConverter::domainToDto)
                .toList();

        return ResponseEntity.ok(filteredImages);
    }

    @Override
    public ResponseEntity<Void> deleteImage(Integer imageId) {
        log.info("Deleting image by id: {}", imageId);
        imageServicePort.deleteImage(imageId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> editImageDescription(ImageDescriptionUpsert imageDescriptionUpsert) {
        log.info("Editing image description: {}", imageDescriptionUpsert);
        Long imageId = imageDescriptionUpsert.getImageId();
        String description = imageDescriptionUpsert.getDescription();
        imageServicePort.editImageDescription(imageId, description);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateImageState(Integer imageId, UpdateImageStateRequest updateImageStateRequest) {
        var state = updateImageStateRequest.getState();
        log.info("Updating state of image {} to {}", imageId, state);

        imageServicePort.updateImageState(imageId, state);
        return ResponseEntity.ok().build();
    }
}
