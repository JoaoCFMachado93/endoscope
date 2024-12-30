package org.example.endoscope.application.spring.configuration.core;

import org.example.endoscope.core.driven.DirectoryRepositoryPort;
import org.example.endoscope.core.driven.ImageRepositoryPort;
import org.example.endoscope.core.driven.UserRepositoryPort;
import org.example.endoscope.core.driver.AuthServicePort;
import org.example.endoscope.core.driver.BackupServicePort;
import org.example.endoscope.core.driver.DirectoryServicePort;
import org.example.endoscope.core.driver.EmailServicePort;
import org.example.endoscope.core.driver.ImageServicePort;
import org.example.endoscope.core.service.BackupService;
import org.example.endoscope.core.service.EmailService;
import org.example.endoscope.core.service.SpringAuthService;
import org.example.endoscope.core.service.SpringDirectoryService;
import org.example.endoscope.core.service.SpringImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
public class EndoscopeCoreConfiguration {

    @Bean
    public DirectoryServicePort directoryServicePort(DirectoryRepositoryPort directoryRepositoryPort) {
        return new SpringDirectoryService(directoryRepositoryPort);
    }

    @Bean
    public ImageServicePort imageServicePort(ImageRepositoryPort imageRepositoryPort,
                                             DirectoryRepositoryPort directoryRepositoryPort,
                                             EmailServicePort emailServicePort) {
        return new SpringImageService(imageRepositoryPort, directoryRepositoryPort, emailServicePort);
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

    @Bean
    public EmailServicePort emailServicePort(JavaMailSender mailSender) {
        return new EmailService(mailSender);
    }

    @Bean
    public JavaMailSender javaMailSender(
            @Value("${spring.mail.host}") String host,
            @Value("${spring.mail.port}") int port,
            @Value("${spring.mail.username}") String username,
            @Value("${spring.mail.password}") String password,
            @Value("${spring.mail.properties.mail.smtp.auth}") boolean smtpAuth,
            @Value("${spring.mail.properties.mail.smtp.starttls.enable}") boolean starttlsEnable,
            @Value("${spring.mail.debug}") boolean debug) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", starttlsEnable);
        props.put("mail.debug", debug);

        return mailSender;
    }
}
