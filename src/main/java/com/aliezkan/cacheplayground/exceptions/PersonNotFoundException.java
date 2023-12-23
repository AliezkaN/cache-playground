package com.aliezkan.cacheplayground.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, code = HttpStatus.NO_CONTENT, reason = "PERSON NOT FOUND")
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super(String.format("Person with id {%s} not found", id));
    }
}
