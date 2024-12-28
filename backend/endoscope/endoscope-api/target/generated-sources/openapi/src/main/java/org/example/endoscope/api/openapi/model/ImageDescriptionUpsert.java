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
 * ImageDescriptionUpsert
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-28T22:35:44.049150Z[Europe/Lisbon]")
public class ImageDescriptionUpsert {

  private Long imageId = null;

  private String description;

  public ImageDescriptionUpsert imageId(Long imageId) {
    this.imageId = imageId;
    return this;
  }

  /**
   * The image ID
   * @return imageId
  */
  
  @Schema(name = "imageId", description = "The image ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageId")
  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public ImageDescriptionUpsert description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The image description
   * @return description
  */
  
  @Schema(name = "description", description = "The image description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageDescriptionUpsert imageDescriptionUpsert = (ImageDescriptionUpsert) o;
    return Objects.equals(this.imageId, imageDescriptionUpsert.imageId) &&
        Objects.equals(this.description, imageDescriptionUpsert.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDescriptionUpsert {\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

