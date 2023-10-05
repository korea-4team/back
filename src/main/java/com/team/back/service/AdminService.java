package com.team.back.service;

import org.springframework.http.ResponseEntity;

<<<<<<< HEAD
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
=======
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
>>>>>>> b721338856a9082176bb5dfa221e92116b798f0e

public interface AdminService {
	
	// 관리자페이지 게시글(기행기, 광고) 목록
	ResponseEntity<?> getBoardList(String adminId);

	// 관리자페이지 한 줄 리뷰 목록
<<<<<<< HEAD
	// 다른 분들이 만들텐데 그 DTO, Entity 사용해서 해도 되는가 아님 Admin에서 쓸 것들을 따로 만들어야하는가
	ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(String adminId);
=======
	ResponseEntity<?> getShortReviewList(String adminId);
>>>>>>> b721338856a9082176bb5dfa221e92116b798f0e

	// 관리자페이지 유저 목록
	ResponseEntity<? super GetUserListResponseDto> getUserList(String adminId);

	// 관리자페이지 유저 상세정보
	ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 광고 게시글 리스트
<<<<<<< HEAD
	// 해당 유저의 글들을 불러오는 것도 다른분들이 만든거 써도 되는가
	// 그 find by 해서 아이디랑 같을 때 들어가지게,,?
	ResponseEntity<? super GetAdvertisingboardResponseDto> getUserAdvertisingBoardList(String adminId, String userEmail);
=======
	ResponseEntity<?> getUserAdvertisingBoardList(String adminId, String userEmail);
>>>>>>> b721338856a9082176bb5dfa221e92116b798f0e

	// 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<?> getUserReviewBoardList(String adminId, String userEmail);

	// 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
<<<<<<< HEAD
	ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail);
=======
	ResponseEntity<?> getUserShortReviewList(String adminId, String userEmail);
>>>>>>> b721338856a9082176bb5dfa221e92116b798f0e

	// 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<?> getUserCommentList(String adminId, String userEmail);

	// 관리자 페이지 메인 페이지 배너 수정 기능
	ResponseEntity<?> PatchMainBanner(String adminId);
}
