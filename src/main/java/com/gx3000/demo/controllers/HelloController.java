package com.gx3000.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gx3000.demo.exception.QueryNotFound;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String name;
    @GetMapping("")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>("here we go， 2022 !!!"+name, HttpStatus.OK);
    }
}