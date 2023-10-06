package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.auth.AccountFindEmailRequestDto;
import com.team.back.dto.request.auth.AccountFindPasswordRequestDto;
import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.request.auth.SignUpRequestDto;
import com.team.back.dto.response.auth.AccountFindEmailResponseDto;
import com.team.back.dto.response.auth.AccountFindPasswordResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super AccountFindEmailResponseDto> accountFindEmail(AccountFindEmailRequestDto dto);
    ResponseEntity<? super AccountFindPasswordResponseDto> accountFindPassword(AccountFindPasswordRequestDto dto);
}
