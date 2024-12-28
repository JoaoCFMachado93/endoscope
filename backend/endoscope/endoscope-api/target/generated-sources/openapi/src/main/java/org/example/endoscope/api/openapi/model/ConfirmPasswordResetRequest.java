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
 * ConfirmPasswordResetRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-28T22:35:44.049150Z[Europe/Lisbon]")
public class ConfirmPasswordResetRequest {

  private String token;

  private String newPassword;

  public ConfirmPasswordResetRequest token(String token) {
    this.token = token;
    return this;
  }

  /**
   * The password reset token
   * @return token
  */
  
  @Schema(name = "token", description = "The password reset token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ConfirmPasswordResetRequest newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * The new password for the user
   * @return newPassword
  */
  
  @Schema(name = "newPassword", description = "The new password for the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("newPassword")
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfirmPasswordResetRequest confirmPasswordResetRequest = (ConfirmPasswordResetRequest) o;
    return Objects.equals(this.token, confirmPasswordResetRequest.token) &&
        Objects.equals(this.newPassword, confirmPasswordResetRequest.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, newPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfirmPasswordResetRequest {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

