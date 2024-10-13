package org.example.endoscope.api.mapper.directory;

import javax.annotation.processing.Generated;
import org.example.endoscope.api.openapi.model.DirectoryEntity;
import org.example.endoscope.core.domain.Directory;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T18:51:06+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class DirectoryConverterImpl implements DirectoryConverter {

    @Override
    public DirectoryEntity domainToDto(Directory directory) {
        if ( directory == null ) {
            return null;
        }

        DirectoryEntity directoryEntity = new DirectoryEntity();

        directoryEntity.setDirectoryId( (int) directory.getDirectoryId() );
        directoryEntity.setDirectoryName( directory.getDirectoryName() );
        directoryEntity.setDirectoryDescription( directory.getDirectoryDescription() );
        directoryEntity.setParentDirectory( (int) directory.getParentDirectory() );
        directoryEntity.setImageCount( directory.getImageCount() );
        directoryEntity.setDirectoryPosition( directory.getDirectoryPosition() );

        return directoryEntity;
    }

    @Override
    public Directory dtoToDomain(DirectoryEntity directory) {
        if ( directory == null ) {
            return null;
        }

        Directory.DirectoryBuilder directory1 = Directory.builder();

        directory1.directoryName( directory.getDirectoryName() );
        directory1.directoryDescription( directory.getDirectoryDescription() );
        if ( directory.getParentDirectory() != null ) {
            directory1.parentDirectory( directory.getParentDirectory() );
        }
        if ( directory.getImageCount() != null ) {
            directory1.imageCount( directory.getImageCount() );
        }
        if ( directory.getDirectoryPosition() != null ) {
            directory1.directoryPosition( directory.getDirectoryPosition() );
        }

        return directory1.build();
    }
}
