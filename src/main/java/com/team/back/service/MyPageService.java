package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.myPage.PatchUserRequestDto;
import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.GetBoardListResponseDto;
import com.team.back.dto.response.myPage.GetMyCommentListResponseDto;
import com.team.back.dto.response.myPage.GetMyReservationListResponseDto;
import com.team.back.dto.response.myPage.GetMyShortReviewListResponseDto;
import com.team.back.dto.response.myPage.GetMyStoreReservationListResponseDto;
import com.team.back.dto.response.myPage.GetStoreInfoResponseDto;
import com.team.back.dto.response.myPage.PatchUserResponseDto;
import com.team.back.dto.response.myPage.PostRegistrationResponseDto;

public interface MyPageService {
    ResponseEntity<? super PostRegistrationResponseDto> registration(RegistrationRequestDto dto, String email);
    ResponseEntity<? super GetBoardListResponseDto> getBoardList(String email);
    ResponseEntity<? super GetStoreInfoResponseDto> getStoreInfo(String email);
    ResponseEntity<? super GetMyCommentListResponseDto> getMyCommentList(String email);
    ResponseEntity<? super GetMyReservationListResponseDto> getMyReservationList(String email);
    ResponseEntity<? super GetMyShortReviewListResponseDto> getMyShortReviewList(String email);
    ResponseEntity<? super GetMyStoreReservationListResponseDto> getMyStoreReservationList(String email);
    ResponseEntity<? super PatchUserResponseDto> patchUser(PatchUserRequestDto dto, String email);
}
