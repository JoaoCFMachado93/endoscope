package org.example.endoscope.core.driver;

public interface EmailServicePort {

    void sendWelcomeEmail(String to, String name);
}
