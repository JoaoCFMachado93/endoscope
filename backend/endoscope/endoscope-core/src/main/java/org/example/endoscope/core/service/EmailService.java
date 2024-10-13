package org.example.endoscope.core.service;

import org.example.endoscope.core.driver.EmailServicePort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServicePort {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Welcome to the ScopeView!");
        message.setText("Hello " + name + ",\n\nWelcome to ScopeView!\nWe're glad to have you on board.\n\nBest regards,\nThe Team");

        mailSender.send(message);
    }
}