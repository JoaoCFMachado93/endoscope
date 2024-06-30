package org.example.endoscope.api.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserEntity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-02T16:56:12.632668+01:00[Europe/Lisbon]")
public class UserEntity {

  private Integer userId;

  private String email;

  private String password;

  private String salutation;

  private String gender;

  private String fullName;

  private String age;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  private String countryOfOrigin;

  private String workLocation;

  private String workPlaceSetting;

  private String medicalId;

  private String medicalSpeciality;

  private String education;

  private String role;

  public UserEntity userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * The user's ID
   * @return userId
  */
  
  @Schema(name = "userId", description = "The user's ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public UserEntity email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user's email address
   * @return email
  */
  @javax.validation.constraints.Email
  @Schema(name = "email", description = "The user's email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserEntity password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The user's password
   * @return password
  */
  
  @Schema(name = "password", description = "The user's password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserEntity salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  /**
   * The user's salutation (e.g., Mr., Ms., Dr.)
   * @return salutation
  */
  
  @Schema(name = "salutation", description = "The user's salutation (e.g., Mr., Ms., Dr.)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("salutation")
  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public UserEntity gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * The user's gender
   * @return gender
  */
  
  @Schema(name = "gender", description = "The user's gender", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public UserEntity fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * The user's full name
   * @return fullName
  */
  
  @Schema(name = "fullName", description = "The user's full name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UserEntity age(String age) {
    this.age = age;
    return this;
  }

  /**
   * The user's age
   * @return age
  */
  
  @Schema(name = "age", description = "The user's age", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("age")
  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public UserEntity dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * The user's date of birth
   * @return dateOfBirth
  */
  @Valid 
  @Schema(name = "dateOfBirth", description = "The user's date of birth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOfBirth")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public UserEntity countryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
    return this;
  }

  /**
   * The user's country of origin
   * @return countryOfOrigin
  */
  
  @Schema(name = "countryOfOrigin", description = "The user's country of origin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("countryOfOrigin")
  public String getCountryOfOrigin() {
    return countryOfOrigin;
  }

  public void setCountryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
  }

  public UserEntity workLocation(String workLocation) {
    this.workLocation = workLocation;
    return this;
  }

  /**
   * The user's work location
   * @return workLocation
  */
  
  @Schema(name = "workLocation", description = "The user's work location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workLocation")
  public String getWorkLocation() {
    return workLocation;
  }

  public void setWorkLocation(String workLocation) {
    this.workLocation = workLocation;
  }

  public UserEntity workPlaceSetting(String workPlaceSetting) {
    this.workPlaceSetting = workPlaceSetting;
    return this;
  }

  /**
   * The user's workplace setting
   * @return workPlaceSetting
  */
  
  @Schema(name = "workPlaceSetting", description = "The user's workplace setting", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workPlaceSetting")
  public String getWorkPlaceSetting() {
    return workPlaceSetting;
  }

  public void setWorkPlaceSetting(String workPlaceSetting) {
    this.workPlaceSetting = workPlaceSetting;
  }

  public UserEntity medicalId(String medicalId) {
    this.medicalId = medicalId;
    return this;
  }

  /**
   * The user's medical ID
   * @return medicalId
  */
  
  @Schema(name = "medicalId", description = "The user's medical ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("medicalId")
  public String getMedicalId() {
    return medicalId;
  }

  public void setMedicalId(String medicalId) {
    this.medicalId = medicalId;
  }

  public UserEntity medicalSpeciality(String medicalSpeciality) {
    this.medicalSpeciality = medicalSpeciality;
    return this;
  }

  /**
   * The user's medical specialty
   * @return medicalSpeciality
  */
  
  @Schema(name = "medicalSpeciality", description = "The user's medical specialty", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("medicalSpeciality")
  public String getMedicalSpeciality() {
    return medicalSpeciality;
  }

  public void setMedicalSpeciality(String medicalSpeciality) {
    this.medicalSpeciality = medicalSpeciality;
  }

  public UserEntity education(String education) {
    this.education = education;
    return this;
  }

  /**
   * The user's education
   * @return education
  */
  
  @Schema(name = "education", description = "The user's education", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("education")
  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public UserEntity role(String role) {
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
    UserEntity userEntity = (UserEntity) o;
    return Objects.equals(this.userId, userEntity.userId) &&
        Objects.equals(this.email, userEntity.email) &&
        Objects.equals(this.password, userEntity.password) &&
        Objects.equals(this.salutation, userEntity.salutation) &&
        Objects.equals(this.gender, userEntity.gender) &&
        Objects.equals(this.fullName, userEntity.fullName) &&
        Objects.equals(this.age, userEntity.age) &&
        Objects.equals(this.dateOfBirth, userEntity.dateOfBirth) &&
        Objects.equals(this.countryOfOrigin, userEntity.countryOfOrigin) &&
        Objects.equals(this.workLocation, userEntity.workLocation) &&
        Objects.equals(this.workPlaceSetting, userEntity.workPlaceSetting) &&
        Objects.equals(this.medicalId, userEntity.medicalId) &&
        Objects.equals(this.medicalSpeciality, userEntity.medicalSpeciality) &&
        Objects.equals(this.education, userEntity.education) &&
        Objects.equals(this.role, userEntity.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, email, password, salutation, gender, fullName, age, dateOfBirth, countryOfOrigin, workLocation, workPlaceSetting, medicalId, medicalSpeciality, education, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserEntity {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    countryOfOrigin: ").append(toIndentedString(countryOfOrigin)).append("\n");
    sb.append("    workLocation: ").append(toIndentedString(workLocation)).append("\n");
    sb.append("    workPlaceSetting: ").append(toIndentedString(workPlaceSetting)).append("\n");
    sb.append("    medicalId: ").append(toIndentedString(medicalId)).append("\n");
    sb.append("    medicalSpeciality: ").append(toIndentedString(medicalSpeciality)).append("\n");
    sb.append("    education: ").append(toIndentedString(education)).append("\n");
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

