package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/")
    public String home() {
        return "This is my test Spring boot.\n\nEndpoints:\n\n/test/hello[?name=YOUR_NAME]";
    }

}
