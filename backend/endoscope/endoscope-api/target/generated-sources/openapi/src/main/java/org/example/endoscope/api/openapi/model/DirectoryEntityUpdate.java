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
 * DirectoryEntityUpdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-28T22:35:44.049150Z[Europe/Lisbon]")
public class DirectoryEntityUpdate {

  private String directoryName;

  private Integer directoryPosition;

  public DirectoryEntityUpdate directoryName(String directoryName) {
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

  public DirectoryEntityUpdate directoryPosition(Integer directoryPosition) {
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
    DirectoryEntityUpdate directoryEntityUpdate = (DirectoryEntityUpdate) o;
    return Objects.equals(this.directoryName, directoryEntityUpdate.directoryName) &&
        Objects.equals(this.directoryPosition, directoryEntityUpdate.directoryPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directoryName, directoryPosition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectoryEntityUpdate {\n");
    sb.append("    directoryName: ").append(toIndentedString(directoryName)).append("\n");
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

