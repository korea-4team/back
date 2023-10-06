package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.noticeBoard.PatchNoticeBoardRequestDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.admin.GetAdvertisingBoardListResponseDto;
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;

public interface AdminService {
	
	// description : 관리자페이지 광고 게시글 목록
	ResponseEntity<? super GetAdvertisingBoardListResponseDto> getAdvertisingBoardList(String adminId);

	// description : 관리자페이지 기행기 게시글 목록
	ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList(String adminId);

	// description : 관리자페이지 한 줄 리뷰 목록
	ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(String adminId);

	// description : 관리자페이지 유저 목록
	ResponseEntity<? super GetUserListResponseDto> getUserList(String adminId);

	// description : 관리자페이지 유저 상세정보
	ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 광고 게시글 리스트
	ResponseEntity<? super GetAdvertisingBoardListResponseDto> getUserAdvertisingBoardList(String adminId, String userEmail);

	// description : 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
	ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail);

	// description : 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail);

	// 관리자 페이지 메인 페이지 배너 작성
	ResponseEntity<?> postNoticeBoard(String adminId, PostNoticeBoardRequestDto dto);

	// 관리자 페이지 메인 페이지 배너 수정
	ResponseEntity<?> patchNoticeBoard(Integer boardNumber, String adminId, PatchNoticeBoardRequestDto dto);

	// 관리자 페이지 메인 페이지 배너 삭제
	ResponseEntity<?> deleteNoticeBoard(Integer boardNumber, String adminId);
}
