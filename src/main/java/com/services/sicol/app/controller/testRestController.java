package com.services.sicol.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testRestController {

    @GetMapping(path = "/")
    public String test() {
        return "Welcome to Sicol Backend";
    }
}
