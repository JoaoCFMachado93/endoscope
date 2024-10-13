package org.example.endoscope.api.mapper.directory;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.example.endoscope.api.openapi.model.ImageEntity;
import org.example.endoscope.core.domain.Image;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T19:02:57+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class ImageConverterImpl implements ImageConverter {

    @Override
    public ImageEntity domainToDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setImageId( (int) image.getImageId() );
        imageEntity.setImageName( image.getImageName() );
        imageEntity.setDirectory( (int) image.getDirectory() );
        imageEntity.setUploadedBy( image.getUploadedBy() );
        imageEntity.setUploadDate( image.getUploadDate() );
        imageEntity.setDescription( image.getDescription() );
        byte[] imageData = image.getImageData();
        if ( imageData != null ) {
            imageEntity.setImageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return imageEntity;
    }

    @Override
    public Image dtoToDomain(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.imageName( imageEntity.getImageName() );
        if ( imageEntity.getDirectory() != null ) {
            image.directory( imageEntity.getDirectory() );
        }
        image.uploadedBy( imageEntity.getUploadedBy() );
        if ( imageEntity.getUploadDate() != null ) {
            image.uploadDate( imageEntity.getUploadDate() );
        }
        image.description( imageEntity.getDescription() );
        byte[] imageData = imageEntity.getImageData();
        if ( imageData != null ) {
            image.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return image.build();
    }
}
