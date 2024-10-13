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
 * DirectoryDescriptionUpsert
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T18:51:05.574743+01:00[Europe/Lisbon]")
public class DirectoryDescriptionUpsert {

  private Long directoryId = null;

  private String description;

  public DirectoryDescriptionUpsert directoryId(Long directoryId) {
    this.directoryId = directoryId;
    return this;
  }

  /**
   * The directory ID
   * @return directoryId
  */
  
  @Schema(name = "directoryId", description = "The directory ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("directoryId")
  public Long getDirectoryId() {
    return directoryId;
  }

  public void setDirectoryId(Long directoryId) {
    this.directoryId = directoryId;
  }

  public DirectoryDescriptionUpsert description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The directory description
   * @return description
  */
  
  @Schema(name = "description", description = "The directory description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    DirectoryDescriptionUpsert directoryDescriptionUpsert = (DirectoryDescriptionUpsert) o;
    return Objects.equals(this.directoryId, directoryDescriptionUpsert.directoryId) &&
        Objects.equals(this.description, directoryDescriptionUpsert.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directoryId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectoryDescriptionUpsert {\n");
    sb.append("    directoryId: ").append(toIndentedString(directoryId)).append("\n");
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

