package org.example.endoscope.output.dbo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "directory")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DirectoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_id")
    private Long directoryId;

    @Column(name = "directory_name")
    private String directoryName;

    @Column(name = "directory_description")
    private String directoryDescription;

    @ManyToOne
    @JoinColumn(name = "parent_directory_id")
    private DirectoryEntity parentDirectory;

    @Column(name = "image_count")
    private Integer imageCount;

    @Column(name = "directory_position")
    private Integer directoryPosition;
}
