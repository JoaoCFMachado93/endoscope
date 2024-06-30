package org.example.endoscope.output.repository;

import org.example.endoscope.output.dbo.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoryJpaRepository extends JpaRepository<DirectoryEntity, Long> {

    List<DirectoryEntity> findByParentDirectory_DirectoryId(long directoryId);

    List<DirectoryEntity> findByParentDirectoryIsNull();
}
