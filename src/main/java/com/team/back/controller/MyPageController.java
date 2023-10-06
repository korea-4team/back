package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.RegistrationResponseDto;
import com.team.back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/my-page")
@RequiredArgsConstructor
public class MyPageController {
    
    private final MyPageService myPageService;

    @PostMapping("/registration")
    public ResponseEntity<? super RegistrationResponseDto> registration(
        @RequestBody @Valid RegistrationRequestDto requestBody,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super RegistrationResponseDto> response = myPageService.registration(requestBody, email);
        return response;
    }

}
