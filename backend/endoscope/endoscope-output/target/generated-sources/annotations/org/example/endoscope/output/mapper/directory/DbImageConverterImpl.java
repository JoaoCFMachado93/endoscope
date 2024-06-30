package org.example.endoscope.output.mapper.directory;

import java.sql.Timestamp;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.example.endoscope.core.domain.Image;
import org.example.endoscope.output.dbo.DirectoryEntity;
import org.example.endoscope.output.dbo.ImageEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:56:19+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class DbImageConverterImpl implements DbImageConverter {

    @Override
    public Image dboToDomain(ImageEntity directory) {
        if ( directory == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        Long directoryId = directoryDirectoryDirectoryId( directory );
        if ( directoryId != null ) {
            image.directory( directoryId );
        }
        if ( directory.getImageId() != null ) {
            image.imageId( directory.getImageId() );
        }
        image.imageName( directory.getImageName() );
        image.uploadedBy( directory.getUploadedBy() );
        if ( directory.getUploadDate() != null ) {
            image.uploadDate( map( new Timestamp( directory.getUploadDate().getTime() ) ) );
        }
        image.description( directory.getDescription() );
        byte[] imageData = directory.getImageData();
        if ( imageData != null ) {
            image.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return image.build();
    }

    @Override
    public ImageEntity domainToDbo(Image directory) {
        if ( directory == null ) {
            return null;
        }

        ImageEntity.ImageEntityBuilder imageEntity = ImageEntity.builder();

        imageEntity.directory( imageToDirectoryEntity( directory ) );
        imageEntity.imageId( directory.getImageId() );
        imageEntity.imageName( directory.getImageName() );
        imageEntity.uploadedBy( directory.getUploadedBy() );
        imageEntity.uploadDate( map( directory.getUploadDate() ) );
        imageEntity.description( directory.getDescription() );
        byte[] imageData = directory.getImageData();
        if ( imageData != null ) {
            imageEntity.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return imageEntity.build();
    }

    private Long directoryDirectoryDirectoryId(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }
        DirectoryEntity directory = imageEntity.getDirectory();
        if ( directory == null ) {
            return null;
        }
        Long directoryId = directory.getDirectoryId();
        if ( directoryId == null ) {
            return null;
        }
        return directoryId;
    }

    protected DirectoryEntity imageToDirectoryEntity(Image image) {
        if ( image == null ) {
            return null;
        }

        DirectoryEntity.DirectoryEntityBuilder directoryEntity = DirectoryEntity.builder();

        directoryEntity.directoryId( image.getDirectory() );

        return directoryEntity.build();
    }
}
