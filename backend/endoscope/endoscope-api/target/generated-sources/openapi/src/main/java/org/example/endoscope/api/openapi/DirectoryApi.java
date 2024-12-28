/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.DirectoryDescriptionUpsert;
import org.example.endoscope.api.openapi.model.DirectoryEntity;
import org.example.endoscope.api.openapi.model.DirectoryEntityUpdate;
import org.example.endoscope.api.openapi.model.InternalServerError;
import java.util.List;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-28T22:35:44.049150Z[Europe/Lisbon]")
@Validated
@Controller
@Tag(name = "directory", description = "directory API")
public interface DirectoryApi {

    default DirectoryApiDelegate getDelegate() {
        return new DirectoryApiDelegate() {};
    }

    /**
     * POST /directories : Add or Edit description of directory
     * Add or Edit description of directory
     *
     * @param directoryDescriptionUpsert Directory description to add or edit (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "addOrEditDirectoryDescription",
        summary = "Add or Edit description of directory",
        description = "Add or Edit description of directory",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/directories",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> addOrEditDirectoryDescription(
        @Parameter(name = "DirectoryDescriptionUpsert", description = "Directory description to add or edit", required = true) @Valid @RequestBody DirectoryDescriptionUpsert directoryDescriptionUpsert
    ) {
        return getDelegate().addOrEditDirectoryDescription(directoryDescriptionUpsert);
    }


    /**
     * PUT /directories : Create directory
     * Create directory
     *
     * @param directoryEntity Directory to create (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "createDirectory",
        summary = "Create directory",
        description = "Create directory",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/directories",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> createDirectory(
        @Parameter(name = "DirectoryEntity", description = "Directory to create", required = true) @Valid @RequestBody List<DirectoryEntity> directoryEntity
    ) {
        return getDelegate().createDirectory(directoryEntity);
    }


    /**
     * PUT /directories/subDirectories/{directoryId} : Create sub directory
     * Create sub directory
     *
     * @param directoryId  (required)
     * @param directoryEntity Sub Directory to create (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "createSubDirectory",
        summary = "Create sub directory",
        description = "Create sub directory",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/directories/subDirectories/{directoryId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> createSubDirectory(
        @Parameter(name = "directoryId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("directoryId") Integer directoryId,
        @Parameter(name = "DirectoryEntity", description = "Sub Directory to create", required = true) @Valid @RequestBody List<DirectoryEntity> directoryEntity
    ) {
        return getDelegate().createSubDirectory(directoryId, directoryEntity);
    }


    /**
     * DELETE /directories/{directoryId} : Delete directory
     * Delete directory
     *
     * @param directoryId  (required)
     * @return Successful operation (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "deleteDirectory",
        summary = "Delete directory",
        description = "Delete directory",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/directories/{directoryId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteDirectory(
        @Parameter(name = "directoryId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("directoryId") Integer directoryId
    ) {
        return getDelegate().deleteDirectory(directoryId);
    }


    /**
     * POST /directories/{directoryId} : Edit directory
     * Edit directory
     *
     * @param directoryId  (required)
     * @param directoryEntityUpdate Directory to edit (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "editDirectory",
        summary = "Edit directory",
        description = "Edit directory",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/directories/{directoryId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> editDirectory(
        @Parameter(name = "directoryId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("directoryId") Integer directoryId,
        @Parameter(name = "DirectoryEntityUpdate", description = "Directory to edit", required = true) @Valid @RequestBody DirectoryEntityUpdate directoryEntityUpdate
    ) {
        return getDelegate().editDirectory(directoryId, directoryEntityUpdate);
    }


    /**
     * GET /directories : Get directories
     * Get directories
     *
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getDirectories",
        summary = "Get directories",
        description = "Get directories",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectoryEntity.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/directories",
        produces = { "application/json" }
    )
    default ResponseEntity<List<DirectoryEntity>> getDirectories(
        
    ) {
        return getDelegate().getDirectories();
    }


    /**
     * GET /directories/{directoryId} : Get directory by ID
     * Get directory by ID
     *
     * @param directoryId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getDirectoryById",
        summary = "Get directory by ID",
        description = "Get directory by ID",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = DirectoryEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/directories/{directoryId}",
        produces = { "application/json" }
    )
    default ResponseEntity<DirectoryEntity> getDirectoryById(
        @Parameter(name = "directoryId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("directoryId") Integer directoryId
    ) {
        return getDelegate().getDirectoryById(directoryId);
    }


    /**
     * GET /directories/subDirectories/{directoryId} : Get sub directories
     * Get sub directories
     *
     * @param directoryId  (required)
     * @return OK (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getSubDirectories",
        summary = "Get sub directories",
        description = "Get sub directories",
        tags = { "directory" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectoryEntity.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/directories/subDirectories/{directoryId}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<DirectoryEntity>> getSubDirectories(
        @Parameter(name = "directoryId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("directoryId") Integer directoryId
    ) {
        return getDelegate().getSubDirectories(directoryId);
    }

}
