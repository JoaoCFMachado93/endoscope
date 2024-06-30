package org.example.endoscope.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor(force = true) // Force creation of a no-args constructor
@Builder(toBuilder = true)
@Data
public class Directory {

    private final long directoryId;
    private final String directoryName;
    private final String directoryDescription;
    private final long parentDirectory;
    private final int imageCount;
    private final int directoryPosition;

}
