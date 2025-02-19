package com.eb2.tmdbclitool.exception;

public class ApiErrorException extends RuntimeException {

    public ApiErrorException(String message) {
        super(message);
    }
}
