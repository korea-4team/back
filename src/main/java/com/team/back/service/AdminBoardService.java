package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.response.advertisingBoard.GetAdvertisingboard;
import com.team.back.dto.response.advertisingBoard.GetShortReviewList;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;

public interface AdminBoardService {
	
	// 관리자페이지 게시글 목록 (기행기, 광고)
	ResponseEntity<?> getBoardList(String adminId);
	// 관리자페이지 한 줄 리뷰 목록
	ResponseEntity<? super GetShortReviewList> getShortReviewList(String adminId);
	// 관리자페이지 유저 목록
	ResponseEntity<?> getUserList(String adminId);
	// 관리자페이지 유저 상세정보
	ResponseEntity<?> getUserDetail(String adminId, String userEmail);
	// 관리자 페이지 해당 유저 작성 광고 게시글 리스트
	ResponseEntity<? super GetAdvertisingboard> getUserAdvertisingBoardList(String adminId, String userEmail);
	// 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail);
	// 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
	ResponseEntity<? super GetShortReviewList> getUserShortReviewList(String adminId, String userEmail);
	// 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail);
	// 관리자 페이지 메인 페이지 배너 수정 기능
	ResponseEntity<?> PatchMainBanner(String adminId);
}
