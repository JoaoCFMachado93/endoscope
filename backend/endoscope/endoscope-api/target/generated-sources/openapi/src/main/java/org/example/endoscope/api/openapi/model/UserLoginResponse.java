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
 * UserLoginResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-02T16:56:12.632668+01:00[Europe/Lisbon]")
public class UserLoginResponse {

  private String token;

  private Long expiration = null;

  private String email;

  private String name;

  private String role;

  public UserLoginResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * The user's token
   * @return token
  */
  
  @Schema(name = "token", description = "The user's token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public UserLoginResponse expiration(Long expiration) {
    this.expiration = expiration;
    return this;
  }

  /**
   * The expiration time of the token
   * @return expiration
  */
  
  @Schema(name = "expiration", description = "The expiration time of the token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiration")
  public Long getExpiration() {
    return expiration;
  }

  public void setExpiration(Long expiration) {
    this.expiration = expiration;
  }

  public UserLoginResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user's email
   * @return email
  */
  
  @Schema(name = "email", description = "The user's email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserLoginResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The user's name
   * @return name
  */
  
  @Schema(name = "name", description = "The user's name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserLoginResponse role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The user's role
   * @return role
  */
  
  @Schema(name = "role", description = "The user's role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLoginResponse userLoginResponse = (UserLoginResponse) o;
    return Objects.equals(this.token, userLoginResponse.token) &&
        Objects.equals(this.expiration, userLoginResponse.expiration) &&
        Objects.equals(this.email, userLoginResponse.email) &&
        Objects.equals(this.name, userLoginResponse.name) &&
        Objects.equals(this.role, userLoginResponse.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, expiration, email, name, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginResponse {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

