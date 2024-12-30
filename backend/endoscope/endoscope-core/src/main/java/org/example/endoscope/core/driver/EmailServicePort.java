package org.example.endoscope.core.driver;

public interface EmailServicePort {

    void sendWelcomeEmail(String to, String name);

    void notifyPendingImage();

    void sendAddedPendingImage(String to);

    void sendApprovedImage(String to);

    void sendDeniedImage(String to);

}
