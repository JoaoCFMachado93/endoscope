package org.example.endoscope.api.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DirectoryEntity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T19:02:56.871329+01:00[Europe/Lisbon]")
public class DirectoryEntity {

  private Integer directoryId;

  private String directoryName;

  private String directoryDescription;

  private Integer parentDirectory;

  private Integer imageCount;

  private Integer directoryPosition;

  public DirectoryEntity directoryId(Integer directoryId) {
    this.directoryId = directoryId;
    return this;
  }

  /**
   * The directory ID
   * @return directoryId
  */
  
  @Schema(name = "directoryId", description = "The directory ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directoryId")
  public Integer getDirectoryId() {
    return directoryId;
  }

  public void setDirectoryId(Integer directoryId) {
    this.directoryId = directoryId;
  }

  public DirectoryEntity directoryName(String directoryName) {
    this.directoryName = directoryName;
    return this;
  }

  /**
   * The directory name
   * @return directoryName
  */
  
  @Schema(name = "directoryName", description = "The directory name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directoryName")
  public String getDirectoryName() {
    return directoryName;
  }

  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  public DirectoryEntity directoryDescription(String directoryDescription) {
    this.directoryDescription = directoryDescription;
    return this;
  }

  /**
   * The directory description
   * @return directoryDescription
  */
  
  @Schema(name = "directoryDescription", description = "The directory description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directoryDescription")
  public String getDirectoryDescription() {
    return directoryDescription;
  }

  public void setDirectoryDescription(String directoryDescription) {
    this.directoryDescription = directoryDescription;
  }

  public DirectoryEntity parentDirectory(Integer parentDirectory) {
    this.parentDirectory = parentDirectory;
    return this;
  }

  /**
   * The parent directory id
   * @return parentDirectory
  */
  
  @Schema(name = "parentDirectory", description = "The parent directory id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parentDirectory")
  public Integer getParentDirectory() {
    return parentDirectory;
  }

  public void setParentDirectory(Integer parentDirectory) {
    this.parentDirectory = parentDirectory;
  }

  public DirectoryEntity imageCount(Integer imageCount) {
    this.imageCount = imageCount;
    return this;
  }

  /**
   * The number of images in the directory
   * @return imageCount
  */
  
  @Schema(name = "imageCount", description = "The number of images in the directory", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageCount")
  public Integer getImageCount() {
    return imageCount;
  }

  public void setImageCount(Integer imageCount) {
    this.imageCount = imageCount;
  }

  public DirectoryEntity directoryPosition(Integer directoryPosition) {
    this.directoryPosition = directoryPosition;
    return this;
  }

  /**
   * The position of the directory
   * @return directoryPosition
  */
  
  @Schema(name = "directoryPosition", description = "The position of the directory", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directoryPosition")
  public Integer getDirectoryPosition() {
    return directoryPosition;
  }

  public void setDirectoryPosition(Integer directoryPosition) {
    this.directoryPosition = directoryPosition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DirectoryEntity directoryEntity = (DirectoryEntity) o;
    return Objects.equals(this.directoryId, directoryEntity.directoryId) &&
        Objects.equals(this.directoryName, directoryEntity.directoryName) &&
        Objects.equals(this.directoryDescription, directoryEntity.directoryDescription) &&
        Objects.equals(this.parentDirectory, directoryEntity.parentDirectory) &&
        Objects.equals(this.imageCount, directoryEntity.imageCount) &&
        Objects.equals(this.directoryPosition, directoryEntity.directoryPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directoryId, directoryName, directoryDescription, parentDirectory, imageCount, directoryPosition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectoryEntity {\n");
    sb.append("    directoryId: ").append(toIndentedString(directoryId)).append("\n");
    sb.append("    directoryName: ").append(toIndentedString(directoryName)).append("\n");
    sb.append("    directoryDescription: ").append(toIndentedString(directoryDescription)).append("\n");
    sb.append("    parentDirectory: ").append(toIndentedString(parentDirectory)).append("\n");
    sb.append("    imageCount: ").append(toIndentedString(imageCount)).append("\n");
    sb.append("    directoryPosition: ").append(toIndentedString(directoryPosition)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

