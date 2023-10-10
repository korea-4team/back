package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.myPage.PatchUserRequestDto;
import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.GetBoardListResponseDto;
import com.team.back.dto.response.myPage.GetMyCommentListResponseDto;
import com.team.back.dto.response.myPage.GetStoreInfoResponseDto;
import com.team.back.dto.response.myPage.PatchUserResponseDto;
import com.team.back.dto.response.myPage.PostRegistrationResponseDto;
import com.team.back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/my-page")
@RequiredArgsConstructor
public class MyPageController {
    
    private final MyPageService myPageService;

    @PostMapping("/registration")
    public ResponseEntity<? super PostRegistrationResponseDto> registration(
        @RequestBody @Valid RegistrationRequestDto requestBody,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostRegistrationResponseDto> response = myPageService.registration(requestBody, email);
        return response;
    }

    @GetMapping("/board-list")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetBoardListResponseDto> response = myPageService.getBoardList(email);
        return response;
    }

    @GetMapping("/comment-list")
    public ResponseEntity<? super GetMyCommentListResponseDto> GetMyCommentList(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetMyCommentListResponseDto> response = myPageService.GetMyCommentList(email);
        return response;
    }

    @GetMapping("/store-info")
    public ResponseEntity<? super GetStoreInfoResponseDto> getStoreInfo(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetStoreInfoResponseDto> response = myPageService.getStoreInfo(email);
        return response;
    }

    @PatchMapping("/user-info-change")
    public ResponseEntity<? super PatchUserResponseDto> patchUser(
        @RequestBody @Valid PatchUserRequestDto dto, 
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PatchUserResponseDto> response = myPageService.patchUser(dto, email);
        return response;
    }

}
