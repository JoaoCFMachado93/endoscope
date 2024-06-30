package org.example.endoscope.application.spring.configuration.core;

import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.core.driven.UserRepositoryPort;
import org.example.endoscope.core.driver.AuthServicePort;
import org.example.endoscope.core.driver.BackupServicePort;
import org.example.endoscope.core.driver.DirectoryServicePort;
import org.example.endoscope.core.driver.ImageServicePort;
import org.example.endoscope.core.service.BackupService;
import org.example.endoscope.core.service.SpringAuthService;
import org.example.endoscope.core.service.SpringDirectoryService;
import org.example.endoscope.core.service.SpringImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EndoscopeCoreConfiguration {

    @Bean
    public DirectoryServicePort directoryServicePort(DirectoryRepositoryPort directoryRepositoryPort) {
        return new SpringDirectoryService(directoryRepositoryPort);
    }

    @Bean
    public ImageServicePort imageServicePort(ImageRepositoryPort imageRepositoryPort,
                                             DirectoryRepositoryPort directoryRepositoryPort) {
        return new SpringImageService(imageRepositoryPort, directoryRepositoryPort);
    }

    @Bean
    public AuthServicePort authServicePort(UserRepositoryPort userRepositoryPort,
                                           PasswordEncoder passwordEncoder,
                                           AuthenticationManager authenticationManager) {
        return new SpringAuthService(userRepositoryPort, passwordEncoder, authenticationManager);
    }

    @Bean
    public BackupServicePort backupServicePort(DirectoryRepositoryPort directoryRepositoryPort,
                                               ImageRepositoryPort imageRepositoryPort,
                                               UserRepositoryPort userRepositoryPort) {
        return new BackupService(directoryRepositoryPort, imageRepositoryPort, userRepositoryPort);
    }
}