package com.esprit.pidevbackend.email;

public interface EmailSender {
    void send(String to, String email);
}
