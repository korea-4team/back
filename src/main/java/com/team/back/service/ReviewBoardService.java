package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;

public interface ReviewBoardService {
  // method : 최신 기행기 게시물 리스트 불러오기 메서드 //
  ResponseEntity<?> getCurrentReviewBoard();
  // method : 기행기 게시물 불러오기 메서드 //
  ResponseEntity<?> getReviewBoard(Integer boardNumber);
  // method : 검색 게시물 리스트 불러오기 //
  ResponseEntity<?> getSearchBoard(String searchWord);
  // method : 특정 게시물의 댓글 리스트 불러오기 //
  ResponseEntity<?> getCommentList(Integer boardNumber);
  // method : 특정 유저의 게시물 리스트 불러오기 //
  ResponseEntity<?> getUserList(String email);
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

}
