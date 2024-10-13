package org.example.endoscope.api;

import lombok.extern.slf4j.Slf4j;
import org.example.endoscope.api.mapper.directory.UserConverter;
import org.example.endoscope.api.openapi.AuthApiDelegate;
import org.example.endoscope.api.openapi.model.UserEntity;
import org.example.endoscope.api.openapi.model.UserLoginRequest;
import org.example.endoscope.api.openapi.model.UserLoginResponse;
import org.example.endoscope.core.domain.User;
import org.example.endoscope.core.driver.AuthServicePort;
import org.example.endoscope.core.driver.BackupServicePort;
import org.example.endoscope.core.driver.EmailServicePort;
import org.example.endoscope.core.service.SpringJwtService;
import org.springframework.http.ResponseEntity;

@Slf4j
public class AuthAPIDelegateImpl implements AuthApiDelegate {

    private final AuthServicePort authServicePort;
    private final SpringJwtService jwtServicePort;
    private final BackupServicePort backupServicePort;
    private final EmailServicePort emailServicePort;
    private final UserConverter userConverter;

    public AuthAPIDelegateImpl(
            AuthServicePort authServicePort,
            SpringJwtService jwtServicePort,
            BackupServicePort backupServicePort,
            EmailServicePort emailServicePort,
            UserConverter userConverter) {
        this.authServicePort = authServicePort;
        this.jwtServicePort = jwtServicePort;
        this.backupServicePort = backupServicePort;
        this.emailServicePort = emailServicePort;
        this.userConverter = userConverter;
    }

    @Override
    public ResponseEntity<Void> registerUser(UserEntity userEntity) {
        log.info("Registering user: {}", userEntity.getEmail());
        var userDomain = userConverter.dtoToDomain(userEntity);
        authServicePort.registerUser(userDomain);

        emailServicePort.sendWelcomeEmail(userEntity.getEmail(), userDomain.getFullName());

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserLoginResponse> loginUser(UserLoginRequest userLoginRequest) {
        log.info("Login the following user: {}", userLoginRequest.getEmail());

        User user = authServicePort.loginUser(userLoginRequest.getEmail(), userLoginRequest.getPassword());

        var jwtToken = jwtServicePort.generateToken(user);

        UserLoginResponse userLoginResponse = new UserLoginResponse()
                .token(jwtToken)
                .expiration(jwtServicePort.getExpirationTime())
                .email(user.getEmail())
                .name(user.getFullName())
                .role(user.getRole());

        return ResponseEntity.ok(userLoginResponse);
    }

    @Override
    public ResponseEntity<Void> generateBackUp() {
        log.info("Generating backup");
        backupServicePort.createBackup();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> uploadBackUp() {
        log.info("Uploading backup");
        backupServicePort.restoreBackup();
        return ResponseEntity.ok().build();
    }
}
