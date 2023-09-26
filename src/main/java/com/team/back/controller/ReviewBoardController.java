package com.team.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.common.response.CustomRsponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/review-board")
@RequiredArgsConstructor
public class ReviewBoardController {

    // API : 기행기 게시물 리스트 최신순으로 불러오기 메서드 //
    @GetMapping("/board-list/{section}")
    public ResponseEntity<?> getReviewBoardList(
        
    ) {
        return CustomRsponse.serviceunavailable;
    }

    // API : 기행기 게시물 지역별 리스트 불러오기 메서드 //
    @GetMapping("/board-list/{location}")
    public ResponseEntity<?> getReviewBoardLocationList(
        @PathVariable("location") String loaction
    ) {
        return CustomRsponse.serviceunavailable;
    }

    // API : 기행기 게시물 업종별 리스트 불러오기 메서드 //
    @GetMapping("/board-list/{businessType}")
    public ResponseEntity<?> getReviewBoardBusinessTypeList(
       @PathVariable("businessType") String businessType
    ) {
        return CustomRsponse.serviceunavailable;
    }

    // API : 기행기 게시물 지역 및 업종별 리스트 불러오기 메서드 //
    @GetMapping("board-list/{location}/{businessType}")
    public ResponseEntity<?> getReviewBoardLocationBusinessTypeList(
        @PathVariable("loaction") String location,
        @PathVariable("businessType") String businessType
    ) {
        return CustomRsponse.serviceunavailable;
    }

    // API : 기행기 게시물 불러오기 메서드 //
    @GetMapping("board-list/{boardNumber}")
    public ResponseEntity<?> getReviewBoard() {
        return CustomRsponse.serviceunavailable;
    }

}