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
 * InternalServerError
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-08T09:38:59.863660+01:00[Europe/Lisbon]")
public class InternalServerError {

  private String message;

  private Integer code;

  public InternalServerError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The error message
   * @return message
  */
  
  @Schema(name = "message", description = "The error message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public InternalServerError code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * The error code
   * @return code
  */
  
  @Schema(name = "code", description = "The error code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternalServerError internalServerError = (InternalServerError) o;
    return Objects.equals(this.message, internalServerError.message) &&
        Objects.equals(this.code, internalServerError.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternalServerError {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

