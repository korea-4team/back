package com.team.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    // 관리자 페이지 메인
    @GetMapping("/{adminId}")
    public static void GetAdminMain() {

    }

    // 관리자 페이지 게시글(기행기, 광고) 목록
    @GetMapping("/{adminId}/board-list")
    public static void GetAdminBoardList() {

    }

    // 전체 한 줄 리뷰 목록
    @GetMapping("/{adminId}/short-review-list")
    public static void GetShortReviewList() {

    }

    // 유저 목록
    @GetMapping("/{adminId}/user-list")
    public static void GetUserList() {

    }

    // 유저 상세 정보
    @GetMapping("/{adminId}/user-list/{userEmail}")
    public static void GetUser() {

    }

    // 해당 유저 작성 광고 게시글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/advertising-board-list")
    public static void GetUserAdvertisingBoardList() {

    }

    // 해당 유저 작성기행기 게시글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/review-board-list")
    public static void GetUserReviewBoardList() {

    }
    
    // 해당 유저 작성 한 줄 리뷰 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/short-review-list")
    public static void GetUserShortReviewList() {

    }

    // 해당 유저 작성 댓글 리스트
    @GetMapping("/{adminId}/user-list/{userEmail}/comment-list")
    public static void GetUserCommentList() {

    }

    // 메인 페이지 배너 수정 기능
    @PatchMapping("/{adminId}/main-banner")
    public static void PatchMainBanner() {

    }
}
