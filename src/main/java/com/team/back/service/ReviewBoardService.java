package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;
import com.team.back.dto.response.reviewBoard.DeleteCommentResponseDto;
import com.team.back.dto.response.reviewBoard.DeleteReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetUserReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.PatchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PostCommentResponseDto;
import com.team.back.dto.response.reviewBoard.PostReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PutFavoriteResponseDto;

public interface ReviewBoardService {
  // method : 기행기 게시물 리스트 최신순으로 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardCurrentList();
  // method : 기행기 게시물 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardResponseDto> getReviewBoard(Integer boardNumber);
  // method : 기행기 게시물 지역별 리스트 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardLocationListResponseDto> getReviewBoardLocationList(String location);
  // method : 기행기 게시물 업종별 리스트 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardBusinessTypeListResponseDto> getReviewBoardBusinessTypeList(String businessType);
  // method : 기행기 게시물 지역 및 업종별 리스트 불러오기 메서드 //
  ResponseEntity<? super GetReviewBoardLocationBusinessTypeListResponseDto> getReviewBoardLocationBusinessTypeList(String location, String businessType);
  // method : 기행기 게시물 검색 리스트 불러오기 //
  ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(String searchWord);
  // method : 특정 게시물의 댓글 리스트 불러오기 //
  ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
  // method : 특정 유저의 기행기 게시물 리스트 불러오기 //
  ResponseEntity<? super GetUserReviewBoardListResponseDto> getUserReviewBoardList(String email);
  // method : 기행기 게시물 작성 메서드 //
  ResponseEntity<? super PostReviewBoardResponseDto> postReviewBoard(String email, PostReviewBoardRequestDto dto);
  // method : 댓글 작성 메서드 //
  ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String email, PostCommentRequestDto dto);
  // method : 좋아요 기능 메서드 //
  ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
  // method : 기행기 게시물 수정 메서드 //
  ResponseEntity<? super PatchReviewBoardResponseDto> patchReviewBoard(Integer boardNumber, String email, PatchReviewBoardRequestDto dto);
  // method : 기행기 게시물 삭제 메서드 //
  ResponseEntity<? super DeleteReviewBoardResponseDto> deleteReviewBoard(Integer boardNumber, String email);
  // method : 댓글 삭제 메서드 //
  ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer boardNumber, String email);
}
