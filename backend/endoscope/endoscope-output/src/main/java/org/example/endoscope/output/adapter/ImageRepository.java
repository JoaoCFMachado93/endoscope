package org.example.endoscope.output.adapter;

import org.example.endoscope.core.domain.Image;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.output.dbo.ImageEntity;
import org.example.endoscope.output.mapper.directory.DbImageConverter;
import org.example.endoscope.output.repository.ImageJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ImageRepository implements ImageRepositoryPort {

    private final ImageJpaRepository imageJpaRepository;
    private final DbImageConverter dbImageConverter;

    public ImageRepository(
            ImageJpaRepository imageJpaRepository,
            DbImageConverter dbImageConverter) {
        this.imageJpaRepository = imageJpaRepository;
        this.dbImageConverter = dbImageConverter;
    }

    @Override
    public void createImageInDirectory(long directoryId, List<Image> image) {
        var imageEntityList = image.stream()
                .map(dbImageConverter::domainToDbo)
                .toList();

        imageJpaRepository.saveAll(imageEntityList);
    }

    @Override
    public Image getImageById(long imageId) {
        return imageJpaRepository.findById(imageId)
                .map(dbImageConverter::dboToDomain)
                .orElseThrow();
    }

    @Override
    public List<Image> getImagesByDirectoryId(long directoryId) {
        return imageJpaRepository.findAllByDirectory_DirectoryId(directoryId).stream()
                .map(dbImageConverter::dboToDomain)
                .toList();
    }

    @Override
    public void deleteImage(long imageId) {
        imageJpaRepository.deleteById(imageId);
    }

    @Override
    public void deleteAllImagesInDirectory(long directoryId) {
        imageJpaRepository.deleteAllByDirectory_DirectoryId(directoryId);
    }

    @Override
    public void editImageDescription(Long imageId, String description) {
        imageJpaRepository.findById(imageId)
                .ifPresent(image -> {
                    image.setDescription(description);
                    imageJpaRepository.save(image);
                });
    }

    @Override
    public List<Image> findAll() {
        return imageJpaRepository.findAll().stream()
                .map(dbImageConverter::dboToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<Image> images) {
        List<ImageEntity> imageEntities = images.stream()
                .map(dbImageConverter::domainToDbo)
                .collect(Collectors.toList());
        imageJpaRepository.saveAll(imageEntities);
    }
}
