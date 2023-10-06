package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.RegistrationResponseDto;

public interface MyPageService {
    ResponseEntity<? super RegistrationResponseDto> registration(RegistrationRequestDto dto, String email);
}
