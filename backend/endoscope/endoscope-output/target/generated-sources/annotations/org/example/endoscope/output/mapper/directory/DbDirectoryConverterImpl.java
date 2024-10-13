package org.example.endoscope.output.mapper.directory;

import javax.annotation.processing.Generated;
import org.example.endoscope.core.domain.Directory;
import org.example.endoscope.output.dbo.DirectoryEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T18:51:09+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class DbDirectoryConverterImpl implements DbDirectoryConverter {

    @Override
    public Directory dboToDomain(DirectoryEntity directory) {
        if ( directory == null ) {
            return null;
        }

        Directory.DirectoryBuilder directory1 = Directory.builder();

        Long directoryId = directoryParentDirectoryDirectoryId( directory );
        if ( directoryId != null ) {
            directory1.parentDirectory( directoryId );
        }
        if ( directory.getDirectoryId() != null ) {
            directory1.directoryId( directory.getDirectoryId() );
        }
        directory1.directoryName( directory.getDirectoryName() );
        directory1.directoryDescription( directory.getDirectoryDescription() );
        if ( directory.getImageCount() != null ) {
            directory1.imageCount( directory.getImageCount() );
        }
        if ( directory.getDirectoryPosition() != null ) {
            directory1.directoryPosition( directory.getDirectoryPosition() );
        }

        return directory1.build();
    }

    @Override
    public DirectoryEntity domainToDbo(Directory directory) {
        if ( directory == null ) {
            return null;
        }

        DirectoryEntity.DirectoryEntityBuilder directoryEntity = DirectoryEntity.builder();

        directoryEntity.parentDirectory( directoryToDirectoryEntity( directory ) );
        directoryEntity.directoryId( directory.getDirectoryId() );
        directoryEntity.directoryName( directory.getDirectoryName() );
        directoryEntity.directoryDescription( directory.getDirectoryDescription() );
        directoryEntity.imageCount( directory.getImageCount() );
        directoryEntity.directoryPosition( directory.getDirectoryPosition() );

        return directoryEntity.build();
    }

    private Long directoryParentDirectoryDirectoryId(DirectoryEntity directoryEntity) {
        if ( directoryEntity == null ) {
            return null;
        }
        DirectoryEntity parentDirectory = directoryEntity.getParentDirectory();
        if ( parentDirectory == null ) {
            return null;
        }
        Long directoryId = parentDirectory.getDirectoryId();
        if ( directoryId == null ) {
            return null;
        }
        return directoryId;
    }

    protected DirectoryEntity directoryToDirectoryEntity(Directory directory) {
        if ( directory == null ) {
            return null;
        }

        DirectoryEntity.DirectoryEntityBuilder directoryEntity = DirectoryEntity.builder();

        directoryEntity.directoryId( directory.getParentDirectory() );

        return directoryEntity.build();
    }
}
