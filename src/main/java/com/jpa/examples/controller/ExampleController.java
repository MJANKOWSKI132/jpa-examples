package com.jpa.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/books")
    public String example() {
        return "example";
    }
}
