package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;

public interface Advertising_Service {

  // method : 최신 광고 게시물 리스트 불러오기 메서드 //
  ResponseEntity<?> getCurrentAdvertisingBoard();  
  ResponseEntity<?> getAdvertisingBoard(Integer boardNumber);
  ResponseEntity<?> getSearchAdvertisingBoard(String searchWord); 
  ResponseEntity<?> getShortReviewList(Integer boardNumber);
  ResponseEntity<?> getUserListAdvertising(Integer boardNumber);
  ResponseEntity<?> postBoard(String email, PostAdvertisingRequestDto dto);
  
  
}
