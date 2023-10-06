package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.auth.AccountFindEmailRequestDto;
import com.team.back.dto.request.auth.AccountFindPasswordRequestDto;
import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.request.auth.SignUpRequestDto;
import com.team.back.dto.response.auth.AccountFindEmailResponseDto;
import com.team.back.dto.response.auth.AccountFindPasswordResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.auth.SignUpResponseDto;
import com.team.back.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp (
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn (
        @RequestBody @Valid SignInRequestDto requestBody
    ) {
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

    @PostMapping("/account-find/email")
    public ResponseEntity<? super AccountFindEmailResponseDto> accountFindEmail (
        @RequestBody @Valid AccountFindEmailRequestDto requestBody
    ) {
        ResponseEntity<? super AccountFindEmailResponseDto> response = authService.accountFindEmail(requestBody);
        return response;
    }

    @PostMapping("/account-find/password")
    public ResponseEntity<? super AccountFindPasswordResponseDto> accountFindPassword (
        @RequestBody @Valid AccountFindPasswordRequestDto requestBody
    ) {
        ResponseEntity<? super AccountFindPasswordResponseDto> response = authService.accountFindPassword(requestBody);
        return response;
    }
    
}
