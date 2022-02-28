package com.esprit.pidevbackend.Exception;

public class UserFoundException extends  RuntimeException {
    public UserFoundException(String messages) {
        super(messages);
    }
}
