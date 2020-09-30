package com.blacktensor.stockWeb.controller;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TestController {

    @GetMapping("")
    public ResponseEntity<String> test(){
        log.info("Call Test Method");
        return ResponseEntity.ok("Test OK");
    }
}
