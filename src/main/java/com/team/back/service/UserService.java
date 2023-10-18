package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    
}
