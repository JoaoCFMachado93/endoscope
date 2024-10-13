package org.example.endoscope.api.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ImageEntity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T19:02:56.871329+01:00[Europe/Lisbon]")
public class ImageEntity {

  private Integer imageId;

  private String imageName;

  private Integer directory;

  private String uploadedBy;

  private Long uploadDate = null;

  private String description;

  private byte[] imageData;

  public ImageEntity imageId(Integer imageId) {
    this.imageId = imageId;
    return this;
  }

  /**
   * The image ID
   * @return imageId
  */
  
  @Schema(name = "imageId", description = "The image ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageId")
  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public ImageEntity imageName(String imageName) {
    this.imageName = imageName;
    return this;
  }

  /**
   * The image name
   * @return imageName
  */
  
  @Schema(name = "imageName", description = "The image name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageName")
  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public ImageEntity directory(Integer directory) {
    this.directory = directory;
    return this;
  }

  /**
   * The directory ID where the image belongs
   * @return directory
  */
  
  @Schema(name = "directory", description = "The directory ID where the image belongs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directory")
  public Integer getDirectory() {
    return directory;
  }

  public void setDirectory(Integer directory) {
    this.directory = directory;
  }

  public ImageEntity uploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
    return this;
  }

  /**
   * The name of the user who uploaded the image
   * @return uploadedBy
  */
  
  @Schema(name = "uploadedBy", description = "The name of the user who uploaded the image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadedBy")
  public String getUploadedBy() {
    return uploadedBy;
  }

  public void setUploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
  }

  public ImageEntity uploadDate(Long uploadDate) {
    this.uploadDate = uploadDate;
    return this;
  }

  /**
   * The upload date of the image in milliseconds since Unix epoch
   * @return uploadDate
  */
  
  @Schema(name = "uploadDate", description = "The upload date of the image in milliseconds since Unix epoch", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadDate")
  public Long getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(Long uploadDate) {
    this.uploadDate = uploadDate;
  }

  public ImageEntity description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the image
   * @return description
  */
  
  @Schema(name = "description", description = "Description of the image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ImageEntity imageData(byte[] imageData) {
    this.imageData = imageData;
    return this;
  }

  /**
   * Binary image data in base64 format
   * @return imageData
  */
  
  @Schema(name = "imageData", description = "Binary image data in base64 format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageData")
  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(byte[] imageData) {
    this.imageData = imageData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageEntity imageEntity = (ImageEntity) o;
    return Objects.equals(this.imageId, imageEntity.imageId) &&
        Objects.equals(this.imageName, imageEntity.imageName) &&
        Objects.equals(this.directory, imageEntity.directory) &&
        Objects.equals(this.uploadedBy, imageEntity.uploadedBy) &&
        Objects.equals(this.uploadDate, imageEntity.uploadDate) &&
        Objects.equals(this.description, imageEntity.description) &&
        Arrays.equals(this.imageData, imageEntity.imageData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, imageName, directory, uploadedBy, uploadDate, description, Arrays.hashCode(imageData));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageEntity {\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    imageName: ").append(toIndentedString(imageName)).append("\n");
    sb.append("    directory: ").append(toIndentedString(directory)).append("\n");
    sb.append("    uploadedBy: ").append(toIndentedString(uploadedBy)).append("\n");
    sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageData: ").append(toIndentedString(imageData)).append("\n");
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

