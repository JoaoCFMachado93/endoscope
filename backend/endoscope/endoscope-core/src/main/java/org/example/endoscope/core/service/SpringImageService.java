package org.example.endoscope.core.service;

import jakarta.transaction.Transactional;
import org.example.endoscope.core.domain.Image;
import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.core.driver.EmailServicePort;
import org.example.endoscope.core.driver.ImageServicePort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpringImageService implements ImageServicePort {

    private final ImageRepositoryPort imageRepositoryPort;
    private final DirectoryRepositoryPort directoryRepositoryPort;
    private final EmailServicePort emailServicePort;
    private final ExecutorService executorService;

    public SpringImageService(ImageRepositoryPort imageRepositoryPort,
                              DirectoryRepositoryPort directoryRepositoryPort,
                              EmailServicePort emailServicePort) {
        this.imageRepositoryPort = imageRepositoryPort;
        this.directoryRepositoryPort = directoryRepositoryPort;
        this.emailServicePort = emailServicePort;
        this.executorService = Executors.newCachedThreadPool();
    }

    @Override
    @Transactional
    public void createImageInDirectory(long directoryId, List<Image> images) {
        if (images.isEmpty()) {
            return;
        }

        if (!directoryRepositoryPort.doesDirectoryExist(directoryId)) {
            throw new IllegalArgumentException("Directory does not exist");
        }

        imageRepositoryPort.createImageInDirectory(directoryId, images);

        for (Image image : images) {
            if ("APPROVED".equals(image.getState())) {
                directoryRepositoryPort.incrementImageCount(directoryId);
            } else if ("PENDING".equals(image.getState())) {
                // Async email notifications
                executorService.submit(() -> {
                    emailServicePort.notifyPendingImage();
                    emailServicePort.sendAddedPendingImage(image.getUploadedBy());
                });
            }
        }
    }

    @Override
    public Image getImageById(long imageId) {
        return imageRepositoryPort.getImageById(imageId);
    }

    @Override
    public List<Image> getImagesByDirectoryId(long directoryId) {
        if (!directoryRepositoryPort.doesDirectoryExist(directoryId)) {
            throw new IllegalArgumentException("Directory does not exist");
        }

        return imageRepositoryPort.getImagesByDirectoryId(directoryId);
    }

    @Override
    @Transactional
    public void deleteImage(long imageId) {
        Image imageById = imageRepositoryPort.getImageById(imageId);
        long directory = imageById.getDirectory();
        imageRepositoryPort.deleteImage(imageId);
        directoryRepositoryPort.decrementImageCount(directory);
    }

    @Override
    @Transactional
    public void editImageDescription(Long imageId, String description) {
        imageRepositoryPort.editImageDescription(imageId, description);
    }

    @Override
    @Transactional
    public void updateImageState(long imageId, String state) {
        var image = imageRepositoryPort.getImageById(imageId);

        image.setState(state);
        imageRepositoryPort.save(image);

        if ("APPROVED".equals(state)) {
            directoryRepositoryPort.incrementImageCount(image.getDirectory());
            // Async email notification for approved state
            executorService.submit(() -> emailServicePort.sendApprovedImage(image.getUploadedBy()));
        } else if ("DENIED".equals(state)) {
            // Async email notification for denied state
            executorService.submit(() -> emailServicePort.sendDeniedImage(image.getUploadedBy()));
        }
    }
}
