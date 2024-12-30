package org.example.endoscope.core.service;

import org.example.endoscope.core.driver.EmailServicePort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServicePort {

    private static final String ADMIN_EMAIL = "luisfilipe.gomes@outlook.com";
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

    @Override
    public void notifyPendingImage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(ADMIN_EMAIL);
        message.setSubject("Nova Contribuição de image no ScopeView!");
        message.setText("Olá Luis,\n\nExiste uma nova Image que precisa da tua aprovação! \n\nMelhores cumprimentos,\nScopeView");
        mailSender.send(message);
    }

    @Override
    public void sendAddedPendingImage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("New Contribution to ScopeView!");
        message.setText("Hello,\n\nThank you for your contribution!\n\nYour image has been added to ScopeView and is pending approval.\n\nBest regards,\nThe Team");
        mailSender.send(message);
    }

    @Override
    public void sendApprovedImage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Contribution to ScopeView!");
        message.setText("Hello,\n\nCongratulations! Your image has been approved and is now available on ScopeView.\n\nBest regards,\nThe Team");
        mailSender.send(message);
    }

    @Override
    public void sendDeniedImage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Contribution to ScopeView!");
        message.setText("Hello,\n\nUnfortunately, your image has been denied and will not be available on ScopeView.\n\nBest regards,\nThe Team");
        mailSender.send(message);
    }

}