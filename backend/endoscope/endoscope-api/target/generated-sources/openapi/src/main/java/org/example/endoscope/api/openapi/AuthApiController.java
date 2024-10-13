package org.example.endoscope.api.openapi;

import org.example.endoscope.api.openapi.model.BadRequestError;
import org.example.endoscope.api.openapi.model.InternalServerError;
import org.example.endoscope.api.openapi.model.UnauthorizedError;
import org.example.endoscope.api.openapi.model.UserEntity;
import org.example.endoscope.api.openapi.model.UserLoginRequest;
import org.example.endoscope.api.openapi.model.UserLoginResponse;


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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T19:02:56.871329+01:00[Europe/Lisbon]")
@Controller
@RequestMapping("${openapi.aPIForEndoscope.base-path:}")
public class AuthApiController implements AuthApi {

    private final AuthApiDelegate delegate;

    public AuthApiController(@Autowired(required = false) AuthApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AuthApiDelegate() {});
    }

    @Override
    public AuthApiDelegate getDelegate() {
        return delegate;
    }

}
