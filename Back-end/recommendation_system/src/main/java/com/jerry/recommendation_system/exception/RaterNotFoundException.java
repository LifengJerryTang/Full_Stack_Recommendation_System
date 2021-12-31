package com.jerry.recommendation_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Rater Not Found!")
public class RaterNotFoundException extends RuntimeException {

    public RaterNotFoundException() {
    }

    public RaterNotFoundException(String message) {
        super(message);
    }
}

