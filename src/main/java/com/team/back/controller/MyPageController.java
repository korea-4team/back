package com.team.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-page")
public class MyPageController {
    
    @PostMapping("/registration")
    public ResponseEntity<?> registration() {
        
    }

}
