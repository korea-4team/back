package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertisingResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;


public interface AdvertisingService {
  // 게시글 삭제
  ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(Integer boardNumber, String email);
  // 한줄리뷰 삭제
  ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertsingBoard(Integer boardNumber,String email);
  // 게시물 불러오기
  ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(Integer boardNumber);
  // 최근 게시물 불러오기
  ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(Integer section);
  // 검색 게시물 리스트 불러오기
  ResponseEntity<? super GetSearchAdvertisingBoardResponseDto> getSearchAdvertisingBoard(String searchWord);
  // 한줄리뷰 리스트 불러오기
  ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(Integer boardNumber);
  // 유저리스트 불러오기
  ResponseEntity<? super GetUserListAdvertisingResponseDto> getUserListAdvertising(String email);
  // 게시물 수정
  ResponseEntity<? super PatchAdvertisingBoardResponseDto> patchAdvertisingBoard(Integer boardNumber, String email, PatchAdvertisingBoardResponseDto dto);
  // 게시물 작성
  ResponseEntity<? super PostAdvertisingBoardResponseDto> postAdvertisingBoard(Integer boardNumber, String email, PostAdvertisingRequestDto dto);
  // 한줄 리뷰 작성
  ResponseEntity<? super PostShortReviewResponseDto> postShortReview(Integer boardNumber, String email, PostAdvertisingRequestDto dto);
}
