package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.DirectoryDescriptionUpsert;
import org.example.endoscope.api.openapi.model.DirectoryEntity;
import org.example.endoscope.api.openapi.model.DirectoryEntityUpdate;
import org.example.endoscope.api.openapi.model.InternalServerError;
import java.util.List;
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
 * A delegate to be called by the {@link DirectoryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T18:51:05.574743+01:00[Europe/Lisbon]")
public interface DirectoryApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /directories : Add or Edit description of directory
     * Add or Edit description of directory
     *
     * @param directoryDescriptionUpsert Directory description to add or edit (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#addOrEditDirectoryDescription
     */
    default ResponseEntity<Void> addOrEditDirectoryDescription(DirectoryDescriptionUpsert directoryDescriptionUpsert) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /directories : Create directory
     * Create directory
     *
     * @param directoryEntity Directory to create (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#createDirectory
     */
    default ResponseEntity<Void> createDirectory(List<DirectoryEntity> directoryEntity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /directories/subDirectories/{directoryId} : Create sub directory
     * Create sub directory
     *
     * @param directoryId  (required)
     * @param directoryEntity Sub Directory to create (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#createSubDirectory
     */
    default ResponseEntity<Void> createSubDirectory(Integer directoryId,
        List<DirectoryEntity> directoryEntity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /directories/{directoryId} : Delete directory
     * Delete directory
     *
     * @param directoryId  (required)
     * @return Successful operation (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#deleteDirectory
     */
    default ResponseEntity<Void> deleteDirectory(Integer directoryId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /directories/{directoryId} : Edit directory
     * Edit directory
     *
     * @param directoryId  (required)
     * @param directoryEntityUpdate Directory to edit (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#editDirectory
     */
    default ResponseEntity<Void> editDirectory(Integer directoryId,
        DirectoryEntityUpdate directoryEntityUpdate) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /directories : Get directories
     * Get directories
     *
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#getDirectories
     */
    default ResponseEntity<List<DirectoryEntity>> getDirectories() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"imageCount\" : 1, \"directoryPosition\" : 5, \"parentDirectory\" : 6, \"directoryId\" : 0, \"directoryDescription\" : \"directoryDescription\", \"directoryName\" : \"directoryName\" }, { \"imageCount\" : 1, \"directoryPosition\" : 5, \"parentDirectory\" : 6, \"directoryId\" : 0, \"directoryDescription\" : \"directoryDescription\", \"directoryName\" : \"directoryName\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /directories/{directoryId} : Get directory by ID
     * Get directory by ID
     *
     * @param directoryId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#getDirectoryById
     */
    default ResponseEntity<DirectoryEntity> getDirectoryById(Integer directoryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"imageCount\" : 1, \"directoryPosition\" : 5, \"parentDirectory\" : 6, \"directoryId\" : 0, \"directoryDescription\" : \"directoryDescription\", \"directoryName\" : \"directoryName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /directories/subDirectories/{directoryId} : Get sub directories
     * Get sub directories
     *
     * @param directoryId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see DirectoryApi#getSubDirectories
     */
    default ResponseEntity<List<DirectoryEntity>> getSubDirectories(Integer directoryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"imageCount\" : 1, \"directoryPosition\" : 5, \"parentDirectory\" : 6, \"directoryId\" : 0, \"directoryDescription\" : \"directoryDescription\", \"directoryName\" : \"directoryName\" }, { \"imageCount\" : 1, \"directoryPosition\" : 5, \"parentDirectory\" : 6, \"directoryId\" : 0, \"directoryDescription\" : \"directoryDescription\", \"directoryName\" : \"directoryName\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
