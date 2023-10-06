package com.team.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.response.admin.GetAdvertisingBoardListResponseDto;
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
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

    // 전체 한 줄 리뷰 목록
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

    // 해당 유저 작성 광고 게시글
    @GetMapping("/{adminId}/user-list/{userEmail}/advertising-board-list")
    public ResponseEntity<? super GetAdvertisingBoardListResponseDto> getUserAdvertisingBoardList(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetAdvertisingBoardListResponseDto> response = adminService.getUserAdvertisingBoardList(adminId, userEmail);
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
    
    // 해당 유저 작성 한 줄 리뷰 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/short-review-list")
    public ResponseEntity<?> getUserShortReviewList(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<?> response = adminService.getUserShortReviewList(adminId, userEmail);
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

    // 메인 페이지 배너 수정 기능
    @PatchMapping("/{adminId}/main-banner")
    public static void patchMainBanner() {

    }
}
