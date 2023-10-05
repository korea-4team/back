package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;

public interface AdminService {
	
	// 관리자페이지 게시글(기행기, 광고) 목록
	// 기행기게시판, 광고글 게시판 두 종류인데 두개를 합치는 VIEW를 만들어서 엔티티, 리포지토리 추가?
	ResponseEntity<?> getBoardList(String adminId);

	// 관리자페이지 한 줄 리뷰 목록
	// 다른 분들이 만들텐데 그 DTO, Entity 사용해서 해도 되는가 아님 Admin에서 쓸 것들을 따로 만들어야하는가
	ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(String adminId);

	// 관리자페이지 유저 목록
	// 유저 목록,리스트 가져오는 건 DTO 새로 만들어야 하는지
	ResponseEntity<?> getUserList(String adminId);

	// 관리자페이지 유저 상세정보
	ResponseEntity<?> getUserDetail(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 광고 게시글 리스트
	// 해당 유저의 글들을 불러오는 것도 다른분들이 만든거 써도 되는가
	// 그 find by 해서 아이디랑 같을 때 들어가지게,,?
	ResponseEntity<? super GetAdvertisingboardResponseDto> getUserAdvertisingBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
	ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail);

	// 관리자 페이지 메인 페이지 배너 수정 기능
	ResponseEntity<?> PatchMainBanner(String adminId);
}
