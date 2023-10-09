package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.banner.PatchBannerRequestDto;
import com.team.back.dto.request.banner.PostBannerRequestDto;
import com.team.back.dto.response.admin.GetAdvertisingBoardListResponseDto;
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.banner.DeleteBannerResponseDto;
import com.team.back.dto.response.banner.GetMainBannerDetailResponseDto;
import com.team.back.dto.response.banner.GetMainBannerListResponseDto;
import com.team.back.dto.response.banner.PatchMainBannerResponseDto;
import com.team.back.dto.response.banner.PostMainBannerResponseDto;
import com.team.back.dto.response.myPage.GetStoreInfoResponseDto;
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

	// description : 관리자 페이지 해당 유저 작성 가게 정보
	ResponseEntity<? super GetStoreInfoResponseDto> getUserStoreInfo(String adminId, String userEmail);

	// description : 관리자 페이지 해당 유저 작성 기행기 게시글 리스트
	ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail);

	// description : 관리자 페이지 해당 유저 작성 한 줄 리뷰 리스트
	ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail);

	// description : 관리자 페이지 해당 유저 작성 댓글 리스트
	ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail);

	// description : 메인 페이지 배너 리스트 불러오기
	ResponseEntity<? super GetMainBannerListResponseDto> getMainBannerList(String adminId);

	// description : 메인 페이지 배너 상세보기
	ResponseEntity<? super GetMainBannerDetailResponseDto> getMainBannerDetail(String adminId, int bannerNumber);

	// 관리자 페이지 메인 페이지 배너 작성
	ResponseEntity<? super PostMainBannerResponseDto> postBanner(String adminId, PostBannerRequestDto dto);

	// 관리자 페이지 메인 페이지 배너 수정
	ResponseEntity<? super PatchMainBannerResponseDto> patchBanner(Integer bannerNumber, String adminId, PatchBannerRequestDto dto);

	// 관리자 페이지 메인 페이지 배너 삭제
	ResponseEntity<? super DeleteBannerResponseDto> deleteBanner(Integer bannerNumber, String adminId);
}
