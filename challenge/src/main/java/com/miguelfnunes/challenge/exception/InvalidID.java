package com.miguelfnunes.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidID extends ResponseStatusException {
    public InvalidID(){
        super(HttpStatus.BAD_REQUEST, "Invalid ID");
    }
}
