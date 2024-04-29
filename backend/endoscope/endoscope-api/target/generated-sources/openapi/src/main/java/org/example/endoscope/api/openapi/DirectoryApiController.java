package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.DirectoryEntity;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-29T10:44:55.956653+01:00[Europe/Lisbon]")
@Controller
@RequestMapping("${openapi.aPIForEndoscope.base-path:}")
public class DirectoryApiController implements DirectoryApi {

    private final DirectoryApiDelegate delegate;

    public DirectoryApiController(@Autowired(required = false) DirectoryApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DirectoryApiDelegate() {});
    }

    @Override
    public DirectoryApiDelegate getDelegate() {
        return delegate;
    }

}
