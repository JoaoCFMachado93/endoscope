package org.example.endoscope.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor(force = true) // Force creation of a no-args constructor
@Builder(toBuilder = true)
@Data
public class Image {

    private final long imageId;
    private final String imageName;
    private final long directory;
    private String uploadedBy;
    private long uploadDate;
    private String description;
    private byte[] imageData;
}
