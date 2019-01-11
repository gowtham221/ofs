package com.objectfrontier.training.java.jdbc.service.service;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ExceptionCodes errorMessage;

    public AppException(ExceptionCodes error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage.getErrorMessage();
    }
}
