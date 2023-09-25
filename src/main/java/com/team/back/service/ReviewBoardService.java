package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;

public interface ReviewBoardService {
  // method : 기행기 게시물 리스트 최신순으로 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList();
  // method : 기행기 게시물 불러오기 메서드 //
  ResponseEntity<?> getReviewBoard(Integer boardNumber);
  // method : 기행기 게시물 지역별 리스트 불러오기 메서드 //
  ResponseEntity<?> getReviewBoardLocationList(String location);
  // method : 기행기 게시물 업종별 리스트 불러오기 메서드 //
  ResponseEntity<?> getReviewBoardBusinessTypeList(String businessType);
  // method : 기행기 게시물 지역 및 업종별 리스트 불러오기 메서드 //
  ResponseEntity<?> getReviewBoardLocationBusinessTypeList(String location, String businessType);
  // method : 기행기 게시물 검색 리스트 불러오기 //
  ResponseEntity<?> getSearchReviewBoard(String searchWord);
  // method : 특정 게시물의 댓글 리스트 불러오기 //
  ResponseEntity<?> getCommentList(Integer boardNumber);
  // method : 특정 유저의 게시물 리스트 불러오기 //
  ResponseEntity<?> getUserReviewBoardList(String email);
  // method : 기행기 게시물 작성 메서드 //
  ResponseEntity<?> postReviewBoard(String email, PostReviewBoardRequestDto dto);
  // method : 댓글 작성 메서드 //
  ResponseEntity<?> postComment(Integer boardNumber, String email, PostCommentRequestDto dto);
  // method : 좋아요 기능 메서드 //
  ResponseEntity<?> putFavorite(Integer boardNumber, String email);
  // method : 기행기 게시물 수정 메서드 //
  ResponseEntity<?> patchReviewBoard(Integer boardNumber, String email, PatchReviewBoardRequestDto dto);
  // method : 기행기 게시물 삭제 메서드 //
  ResponseEntity<?> deleteReviewBoard(Integer boardNumber, String email);
  // method : 댓글 삭제 메서드 //
  ResponseEntity<?> deleteComment(Integer boardNumber, String email);
}
