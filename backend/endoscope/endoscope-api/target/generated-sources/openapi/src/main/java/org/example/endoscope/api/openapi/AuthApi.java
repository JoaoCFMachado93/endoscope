/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.BadRequestError;
import org.example.endoscope.api.openapi.model.InternalServerError;
import org.example.endoscope.api.openapi.model.UnauthorizedError;
import org.example.endoscope.api.openapi.model.UserEntity;
import org.example.endoscope.api.openapi.model.UserLoginRequest;
import org.example.endoscope.api.openapi.model.UserLoginResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-29T12:56:11.484884+01:00[Europe/Lisbon]")
@Validated
@Controller
@Tag(name = "auth", description = "auth API")
public interface AuthApi {

    default AuthApiDelegate getDelegate() {
        return new AuthApiDelegate() {};
    }

    /**
     * POST /auth/login : Authenticate user and generate JWT token
     * Authenticate user with email and password, and generate JWT token
     *
     * @param userLoginRequest User login credentials (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "loginUser",
        summary = "Authenticate user and generate JWT token",
        description = "Authenticate user with email and password, and generate JWT token",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserLoginResponse.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UnauthorizedError.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserLoginResponse> loginUser(
        @Parameter(name = "UserLoginRequest", description = "User login credentials", required = true) @Valid @RequestBody UserLoginRequest userLoginRequest
    ) {
        return getDelegate().loginUser(userLoginRequest);
    }


    /**
     * POST /auth/signup : Register a new user
     * Register a new user
     *
     * @param userEntity User registration data (required)
     * @return User registered successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "registerUser",
        summary = "Register a new user",
        description = "Register a new user",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestError.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/signup",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> registerUser(
        @Parameter(name = "UserEntity", description = "User registration data", required = true) @Valid @RequestBody UserEntity userEntity
    ) {
        return getDelegate().registerUser(userEntity);
    }

}
