package org.example.endoscope.output.repository;

import org.example.endoscope.output.dbo.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageJpaRepository extends JpaRepository<ImageEntity, Long> {

    List<ImageEntity> findAllByDirectory_DirectoryId(long directoryId);

    void deleteAllByDirectory_DirectoryId(long directoryId);
}
