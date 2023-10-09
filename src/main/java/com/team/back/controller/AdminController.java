package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.team.back.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // description : 관리자 페이지 광고 전체 게시글 목록
    @GetMapping("/{adminId}/advertising-board-list")
    public ResponseEntity<? super GetAdvertisingBoardListResponseDto> getAdvertisingBoardList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetAdvertisingBoardListResponseDto> response = adminService.getAdvertisingBoardList(adminId);
        return response;
    }

    // description : 관리자 페이지 기행기 전체 게시글 목록
    @GetMapping("/{adminId}/review-board-list")
    public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetReviewBoardListResponseDto> response = adminService.getReviewBoardList(adminId);
        return response;
    }

    // description : 전체 한 줄 리뷰 목록
    @GetMapping("/{adminId}/short-review-list")
    public ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetShortReviewListResponseDto> response = adminService.getShortReviewList(adminId);
        return response;
    }

    // description : 유저 목록
    @GetMapping("/{adminId}/user-list")
    public ResponseEntity<? super GetUserListResponseDto> getUserList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetUserListResponseDto> response = adminService.getUserList(adminId);
        return response;
    }

    // description : 유저 상세 정보
    @GetMapping("/{adminId}/user-list/{userEmail}")
    public ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetUserDetailResponseDto> response = adminService.getUserDetail(adminId, userEmail);
        return response;
    }

    // description : 해당 유저 작성 사업자 등록 가게 정보
    @GetMapping("/{adminId}/user-list/{userEmail}/store-info")
    public ResponseEntity<? super GetStoreInfoResponseDto> getUserStoreInfo(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetStoreInfoResponseDto> response = adminService.getUserStoreInfo(adminId, userEmail);
        return response;
    }

    // description : 해당 유저 작성기행기 게시글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/review-board-list")
    public ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetReviewBoardListResponseDto> response = adminService.getUserReviewBoardList(adminId, userEmail);
        return response;
    }
    
    // description : 해당 유저 작성 한 줄 리뷰 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/short-review-list")
    public ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetShortReviewListResponseDto> response = adminService.getUserShortReviewList(adminId, userEmail);
        return response;
    }

    // description : 해당 유저 작성 댓글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetCommentListResponseDto> response = adminService.getUserCommentList(adminId, userEmail);
        return response;
    }

    //  description : 베너 리스트 불러오기
    @GetMapping("/{adminId}/main-banner/list")
    public ResponseEntity<? super GetMainBannerListResponseDto> GetMainBannerList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetMainBannerListResponseDto> response = adminService.getMainBannerList(adminId);
        return response;
    }

    // description : 베너 상세보기
    @GetMapping("/{adminId}/main-banner/detail/{bannerNumber}")
    public ResponseEntity<? super GetMainBannerDetailResponseDto> GetMainBannerDetail(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "bannerNumber", required = true) int bannerNumber
    ) {
        ResponseEntity<? super GetMainBannerDetailResponseDto> response = adminService.getMainBannerDetail(adminId, bannerNumber);
        return response;
    }

    // 메인 페이지 배너 작성 기능
    @PostMapping("/write/main-banner")
    public ResponseEntity<? super PostMainBannerResponseDto> postMainBanner(
        @AuthenticationPrincipal String adminId, @RequestBody @Valid PostBannerRequestDto requestBody
    ) {
        ResponseEntity<? super PostMainBannerResponseDto> response = adminService.postBanner(adminId, requestBody);
        return response;
    }
    // 메인 페이지 배너 수정 기능
    @PatchMapping("/update/{bannerNumber}/main-banner")
    public ResponseEntity<? super PatchMainBannerResponseDto> patchMainBanner(
        @AuthenticationPrincipal String adminId, @PathVariable(value = "bannerNumber", required = true) Integer bannerNumber, @RequestBody @Valid PatchBannerRequestDto requestBody
    ) {
        ResponseEntity<? super PatchMainBannerResponseDto> response = adminService.patchBanner(bannerNumber, adminId, requestBody);
        return response;
    }

    // 메인 페이지 배너 삭제 기능
    @DeleteMapping("/delete/{bannerNumber}/main-banner")
    public ResponseEntity<? super DeleteBannerResponseDto> deleteMainBanner(
        @AuthenticationPrincipal String adminId, @PathVariable(value = "bannerNumber", required = true) Integer bannerNumber
    ) {
        ResponseEntity<? super DeleteBannerResponseDto> response = adminService.deleteBanner(bannerNumber, adminId);
        return response;
    }

}
