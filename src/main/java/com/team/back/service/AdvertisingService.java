package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoard;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoard;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboard;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoard;
import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoard;
import com.team.back.dto.response.advertisingBoard.GetShortReviewList;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertising;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoard;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoard;

public interface AdvertisingService {

  // method : 최신 광고 게시물 리스트 불러오기 메서드 //
  ResponseEntity<? super GetCurrentAdvertisingBoard> getCurrentAdvertisingBoard();
  // method : 광고 게시물 불러오기 메서드 //
  ResponseEntity<? super GetAdvertisingboard> getAdvertisingBoard(Integer boardNumber);
  // method : 광고 게시물 검색 리스트 불러오기
  ResponseEntity<? super GetSearchAdvertisingBoard> getSearchAdvertisingBoard(String searchWord);
  // method : 광고 게시물 한줄 리뷰 리스트 불러오기
  ResponseEntity<? super GetShortReviewList> getShortReviewList(Integer boardNumber);
  // method : 특정 유저 게시물 리스트 불러오기 //
  ResponseEntity<? super GetUserListAdvertising> getUserListAdvertising(Integer boardNumber);
  // method : 광고 게시물 작성 메서드//
  ResponseEntity<? super PostAdvertisingBoard> postAdvertisingBoard(String email, PostAdvertisingRequestDto dto);
  // method : 광고 게시물 수정 메서드//
  ResponseEntity<? super PatchAdvertisingBoard> patchAdvertisingBoard(Integer boardNumber, String email, PatchAdvertisingRequestDto dto);
  // method : 광고 게시물 삭제 메서드 //
  ResponseEntity<? super DeleteAdvertisingBoard> deleteAdvertisingBoard(Integer boardNumber, String email);
  // method : 광고 게시물 한줄 리뷰 삭제 메서드 //
  ResponseEntity<? super DeleteShortCommentAdvertisingBoard> deleteShortCommentAdvertisingBoard(Integer boardNumber, String email);


  
  
  
}
