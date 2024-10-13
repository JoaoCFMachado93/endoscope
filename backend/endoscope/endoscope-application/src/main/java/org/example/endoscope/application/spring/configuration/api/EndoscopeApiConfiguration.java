package org.example.endoscope.application.spring.configuration.api;

import org.example.endoscope.api.AuthAPIDelegateImpl;
import org.example.endoscope.api.DirectoriesAPIDelegateImpl;
import org.example.endoscope.api.ImagesAPIDelegateImpl;
import org.example.endoscope.api.mapper.directory.DirectoryConverter;
import org.example.endoscope.api.mapper.directory.ImageConverter;
import org.example.endoscope.api.mapper.directory.UserConverter;
import org.example.endoscope.api.openapi.AuthApiDelegate;
import org.example.endoscope.api.openapi.DirectoryApiDelegate;
import org.example.endoscope.api.openapi.ImageApiDelegate;
import org.example.endoscope.core.driver.AuthServicePort;
import org.example.endoscope.core.driver.BackupServicePort;
import org.example.endoscope.core.driver.DirectoryServicePort;
import org.example.endoscope.core.driver.EmailServicePort;
import org.example.endoscope.core.driver.ImageServicePort;
import org.example.endoscope.core.service.SpringJwtService;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EndoscopeApiConfiguration implements WebMvcConfigurer {

    @Bean
    public DirectoryApiDelegate directoriesApiDelegate(
            DirectoryServicePort directoryServicePort,
            DirectoryConverter directoryConverter) {
        return new DirectoriesAPIDelegateImpl(directoryServicePort, directoryConverter);
    }

    @Bean
    public DirectoryConverter directoryConverter() {
        return Mappers.getMapper(DirectoryConverter.class);
    }

    @Bean
    public ImageApiDelegate ImageApiDelegate(
            ImageServicePort imageServicePort,
            ImageConverter imageConverter) {
        return new ImagesAPIDelegateImpl(imageServicePort, imageConverter);
    }

    @Bean
    public ImageConverter imageConverter() {
        return Mappers.getMapper(ImageConverter.class);
    }

    @Bean
    public AuthApiDelegate authApiDelegate(
            AuthServicePort authServicePort,
            SpringJwtService jwtServicePort,
            BackupServicePort backupServicePort,
            EmailServicePort emailServicePort,
            UserConverter userConverter) {
        return new AuthAPIDelegateImpl(
                authServicePort, jwtServicePort, backupServicePort, emailServicePort, userConverter);
    }

    @Bean
    public UserConverter userConverter() {
        return Mappers.getMapper(UserConverter.class);
    }

}
