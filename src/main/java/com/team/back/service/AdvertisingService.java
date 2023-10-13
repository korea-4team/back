package com.team.back.service;


import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostShortReviewRequestDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardLocationBusinessTypeListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardLocationListResponsedto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertisingResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostReservationResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;
import com.team.back.dto.response.advertisingBoard.PutAdvertisingFavoriteListResponseDto;



public interface AdvertisingService {
  // 게시글 삭제
  ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(Integer boardNumber, String email);
  // 한줄리뷰 삭제
  ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertsingBoard(Integer boardNumber,String email);
  // 게시물 불러오기
  ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(Integer boardNumber);
  // 최근 게시물 불러오기
  ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(Integer section);
  // 한줄리뷰 리스트 불러오기
  ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(Integer boardNumber);
  // 유저리스트 불러오기
  ResponseEntity<? super GetUserListAdvertisingResponseDto> getUserListAdvertising(String email);
  // 게시물 수정
  ResponseEntity<? super PatchAdvertisingBoardResponseDto> patchAdvertisingBoard(Integer boardNumber, String email,PatchAdvertisingRequestDto requestDto);
  // 게시물 작성
  ResponseEntity<? super PostAdvertisingBoardResponseDto> postAdvertisingBoard(String email, PostAdvertisingRequestDto dto);
  // 한줄 리뷰 작성
  ResponseEntity<? super PostShortReviewResponseDto> postShortReview(Integer boardNumber, String email, PostShortReviewRequestDto dto);
  // 좋아요
  ResponseEntity<? super PutAdvertisingFavoriteListResponseDto> putAdvertisingFavoriteList(Integer boardNumber, String writerEmail);
  // 지역별
  ResponseEntity<? super GetAdvertisingBoardLocationListResponsedto> getAdvertisingBoardLocationList(String location);
  // 업종별
  ResponseEntity<? super GetAdvertisingBoardBusinessTypeListResponseDto> getAdvertisingBoardBusinessTypeList(String businessType);
  // 장소 지역 동시
   ResponseEntity<? super GetAdvertisingBoardLocationBusinessTypeListResponseDto> getAdvertisingBoardLocationBusinessTypeList(String location, String businessType);
  //예약
  ResponseEntity<? super PostReservationResponseDto> postReservation(Integer boardNumber, String email, String time, int people);
}
