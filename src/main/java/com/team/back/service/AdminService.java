package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;

public interface AdminService {
	
	// 관리자페이지 게시글(기행기, 광고) 목록
	ResponseEntity<?> getBoardList(String adminId);

	// 관리자페이지 한 줄 리뷰 목록
	ResponseEntity<?> getShortReviewList(String adminId);

	// 관리자페이지 유저 목록
	ResponseEntity<? super GetUserListResponseDto> getUserList(String adminId);

	// 관리자페이지 유저 상세정보
	ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 광고 게시글 리스트
	ResponseEntity<?> getUserAdvertisingBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<?> getUserReviewBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
	ResponseEntity<?> getUserShortReviewList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<?> getUserCommentList(String adminId, String userEmail);

	// 관리자 페이지 메인 페이지 배너 수정 기능
	ResponseEntity<?> PatchMainBanner(String adminId);
}
