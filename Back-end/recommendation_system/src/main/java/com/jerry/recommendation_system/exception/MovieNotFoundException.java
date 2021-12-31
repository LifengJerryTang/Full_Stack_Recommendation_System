package com.jerry.recommendation_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie Not Found!")
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}

