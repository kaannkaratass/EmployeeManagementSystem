package com.example.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GeneralException extends RuntimeException{

    public GeneralException(String message){
        super(message);
    }
}
