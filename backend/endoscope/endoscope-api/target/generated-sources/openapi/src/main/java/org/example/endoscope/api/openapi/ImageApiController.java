package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.ImageDescriptionUpsert;
import org.example.endoscope.api.openapi.model.ImageEntity;
import org.example.endoscope.api.openapi.model.InternalServerError;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T18:51:05.574743+01:00[Europe/Lisbon]")
@Controller
@RequestMapping("${openapi.aPIForEndoscope.base-path:}")
public class ImageApiController implements ImageApi {

    private final ImageApiDelegate delegate;

    public ImageApiController(@Autowired(required = false) ImageApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ImageApiDelegate() {});
    }

    @Override
    public ImageApiDelegate getDelegate() {
        return delegate;
    }

}
