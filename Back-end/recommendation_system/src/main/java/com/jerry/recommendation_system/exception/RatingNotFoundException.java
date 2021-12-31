package com.jerry.recommendation_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Rating Not Found!")
public class RatingNotFoundException extends RuntimeException {

    public RatingNotFoundException() {
    }

    public RatingNotFoundException(String message) {
        super(message);
    }
}
