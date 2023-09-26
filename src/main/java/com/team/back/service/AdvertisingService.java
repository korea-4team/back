package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;

public interface AdvertisingService {

  // method : 최신 광고 게시물 리스트 불러오기 메서드 //
  ResponseEntity<?> getCurrentAdvertisingBoard();  
  // method : 광고 게시물 불러오기 메서드 //
  ResponseEntity<?> getAdvertisingBoard(Integer boardNumber);
  // method : 광고 게시물 검색 리스트 불러오기
  ResponseEntity<?> getSearchAdvertisingBoard(String searchWord);
  // method : 광고 게시물 한줄 리뷰 리스트 불러오기 
  ResponseEntity<?> getShortReviewList(Integer boardNumber);
  // method : 특정 유저 게시물 리스트 불러오기 //
  ResponseEntity<?> getUserListAdvertising(Integer boardNumber);
  // method : 광고 게시물 작성 메서드//
  ResponseEntity<?> postAdvertisingBoard(String email, PostAdvertisingRequestDto dto);
  // method : 광고 게시물 수정 메서드//
  ResponseEntity<?> patchAdvertisingBoard(Integer boardNumber, String email, PatchAdvertisingRequestDto dto);
  // method : 광고 게시물 삭제 메서드 //
  ResponseEntity<?> deleteAdvertisingBoard(Integer boardNumber, String email);
  // method : 광고 게시물 한줄 리뷰 삭제 메서드 //
  ResponseEntity<?> deleteShortCommentAdvertisingBoard(Integer boardNumber, String email);


  
  
  
}
