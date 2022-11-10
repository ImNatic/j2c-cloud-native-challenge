package com.miguelfnunes.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IDNotFound extends ResponseStatusException {
    public IDNotFound(){
        super(HttpStatus.BAD_REQUEST, "ID Not Found");
    }
}
