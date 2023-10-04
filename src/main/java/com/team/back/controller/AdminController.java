package com.team.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // 관리자 페이지 메인
    @GetMapping("/{adminId}")
    public static void getAdminMain() {
        
    }

    // 관리자 페이지 게시글(기행기, 광고) 목록
    @GetMapping("/{adminId}/board-list")
    public static void getAdminBoardList() {
        
    }

    // 전체 한 줄 리뷰 목록
    @GetMapping("/{adminId}/short-review-list")
    public static void getShortReviewList() {
    }

    // 유저 목록
    @GetMapping("/{adminId}/user-list")
    public ResponseEntity<? super GetUserListResponseDto> getUserList(
        @PathVariable(value = "adminId", required = true) String adminId
    ) {
        ResponseEntity<? super GetUserListResponseDto> response = adminService.getUserList(adminId);
        return response;
    }

    // 유저 상세 정보
    @GetMapping("/{adminId}/user-list/{userEmail}")
    public ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(
        @PathVariable(value = "adminId", required = true) String adminId,
        @PathVariable(value = "userEmail", required = true) String userEmail
    ) {
        ResponseEntity<? super GetUserDetailResponseDto> response = adminService.getUserDetail(adminId, userEmail);
        return response;
    }

    // 해당 유저 작성 광고 게시글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/advertising-board-list")
    public static void getUserAdvertisingBoardList( ) {

    }

    // 해당 유저 작성기행기 게시글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/review-board-list")
    public static void getUserReviewBoardList() {
    }
    
    // 해당 유저 작성 한 줄 리뷰 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/short-review-list")
    public static void getUserShortReviewList() {
    }

    // 해당 유저 작성 댓글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/comment-list")
    public static void getUserCommentList( ) {
    }

    // 메인 페이지 배너 수정 기능
    @PatchMapping("/{adminId}/main-banner")
    public static void patchMainBanner() {

    }
}
