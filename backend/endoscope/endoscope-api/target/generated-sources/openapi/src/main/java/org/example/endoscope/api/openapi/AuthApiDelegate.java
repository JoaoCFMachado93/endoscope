package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.BadRequestError;
import org.example.endoscope.api.openapi.model.InternalServerError;
import org.example.endoscope.api.openapi.model.UnauthorizedError;
import org.example.endoscope.api.openapi.model.UserEntity;
import org.example.endoscope.api.openapi.model.UserLoginRequest;
import org.example.endoscope.api.openapi.model.UserLoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AuthApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T19:02:56.871329+01:00[Europe/Lisbon]")
public interface AuthApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /auth/generateBackUp : Generate backup of the database
     * Generate backup of the database
     *
     * @return Backup generated successfully (status code 200)
     *         or Internal Server Error (status code 500)
     * @see AuthApi#generateBackUp
     */
    default ResponseEntity<Void> generateBackUp() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /auth/login : Authenticate user and generate JWT token
     * Authenticate user with email and password, and generate JWT token
     *
     * @param userLoginRequest User login credentials (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     * @see AuthApi#loginUser
     */
    default ResponseEntity<UserLoginResponse> loginUser(UserLoginRequest userLoginRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"role\", \"name\" : \"name\", \"expiration\" : \"\", \"email\" : \"email\", \"token\" : \"token\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /auth/signup : Register a new user
     * Register a new user
     *
     * @param userEntity User registration data (required)
     * @return User registered successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see AuthApi#registerUser
     */
    default ResponseEntity<Void> registerUser(UserEntity userEntity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /auth/uploadBackup : Upload backup of the database
     * Upload backup of the database
     *
     * @return Backup upload successfully (status code 200)
     *         or Internal Server Error (status code 500)
     * @see AuthApi#uploadBackUp
     */
    default ResponseEntity<Void> uploadBackUp() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
