package com.gx3000.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gx3000.demo.exception.QueryNotFound;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value =  QueryNotFound.class)
    public ResponseEntity<Object> exception(QueryNotFound exception) {
        return new ResponseEntity<>("here err happened!", HttpStatus.NOT_FOUND);
    }
}
