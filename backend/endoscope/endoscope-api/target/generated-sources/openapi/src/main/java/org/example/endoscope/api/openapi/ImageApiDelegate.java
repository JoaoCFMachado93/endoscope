package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.ImageDescriptionUpsert;
import org.example.endoscope.api.openapi.model.ImageEntity;
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
 * A delegate to be called by the {@link ImageApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-08T09:38:59.863660+01:00[Europe/Lisbon]")
public interface ImageApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /images/directory/{directoryId} : Create image in directory
     * Create image in directory
     *
     * @param directoryId  (required)
     * @param imageEntity Image to create (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see ImageApi#createImageInDirectory
     */
    default ResponseEntity<Void> createImageInDirectory(Integer directoryId,
        List<ImageEntity> imageEntity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /images/{imageId} : Delete image
     * Delete image
     *
     * @param imageId  (required)
     * @return Successful operation (status code 200)
     *         or Internal Server Error (status code 500)
     * @see ImageApi#deleteImage
     */
    default ResponseEntity<Void> deleteImage(Integer imageId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /images : Edit description of Image
     * Edit description of Image
     *
     * @param imageDescriptionUpsert Image description to edit (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see ImageApi#editImageDescription
     */
    default ResponseEntity<Void> editImageDescription(ImageDescriptionUpsert imageDescriptionUpsert) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /images/{imageId} : Get image  by ID
     * Get image  by ID
     *
     * @param imageId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see ImageApi#getImageById
     */
    default ResponseEntity<ImageEntity> getImageById(Integer imageId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"imageId\" : 0, \"imageName\" : \"imageName\", \"uploadDate\" : \"\", \"imageData\" : \"imageData\", \"description\" : \"description\", \"directory\" : 6, \"uploadedBy\" : \"uploadedBy\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /images/directory/{directoryId} : Get Images by directory ID
     * Get Images by directory ID
     *
     * @param directoryId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     * @see ImageApi#getImagesByDirectoryId
     */
    default ResponseEntity<List<ImageEntity>> getImagesByDirectoryId(Integer directoryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"imageId\" : 0, \"imageName\" : \"imageName\", \"uploadDate\" : \"\", \"imageData\" : \"imageData\", \"description\" : \"description\", \"directory\" : 6, \"uploadedBy\" : \"uploadedBy\" }, { \"imageId\" : 0, \"imageName\" : \"imageName\", \"uploadDate\" : \"\", \"imageData\" : \"imageData\", \"description\" : \"description\", \"directory\" : 6, \"uploadedBy\" : \"uploadedBy\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
