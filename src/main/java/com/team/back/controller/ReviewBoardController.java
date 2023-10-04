package com.team.back.controller;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.common.response.CustomRsponse;
import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;
import com.team.back.dto.response.reviewBoard.DeleteCommentResponseDto;
import com.team.back.dto.response.reviewBoard.DeleteReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetUserReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.PatchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PostCommentResponseDto;
import com.team.back.dto.response.reviewBoard.PostReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PutFavoriteResponseDto;
import com.team.back.service.ReviewBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/review-board")
@RequiredArgsConstructor
public class ReviewBoardController {

    private final ReviewBoardService reviewBoardService;

    // API : 기행기 게시물 리스트 최신순으로 불러오기 메서드 //
    @GetMapping("/board-list/{section}")
    public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList(
        @PathVariable(value = "section", required = true) Integer section
    ) {
        ResponseEntity<? super GetReviewBoardListResponseDto> response = reviewBoardService.getReviewBaordList(section);
        return response;
    }

    // API : 기행기 게시물 지역별 리스트 불러오기 메서드 //
    @GetMapping("/board-list/{location}")
    public ResponseEntity<? super GetReviewBoardLocationListResponseDto> getReviewBoardLocationList(
        @PathVariable(value = "location", required = true) String loaction
    ) {
        ResponseEntity<? super GetReviewBoardLocationListResponseDto> response = reviewBoardService.getReviewBoardLocationList(loaction);
        return response;
    }

    // API : 기행기 게시물 업종별 리스트 불러오기 메서드 //
    @GetMapping("/board-list/{businessType}")
    public ResponseEntity<? super GetReviewBoardBusinessTypeListResponseDto> getReviewBoardBusinessTypeList(
       @PathVariable(value = "businessType", required = true) String businessType
    ) {
        ResponseEntity<? super GetReviewBoardBusinessTypeListResponseDto> response = reviewBoardService.getReviewBoardBusinessTypeList(businessType);
        return response;
    }

    // API : 기행기 게시물 지역 및 업종별 리스트 불러오기 메서드 //
    @GetMapping("board-list/{location}/{businessType}")
    public ResponseEntity<? super GetReviewBoardLocationBusinessTypeListResponseDto> getReviewBoardLocationBusinessTypeList(
        @PathVariable(value = "loaction", required = true) String location,
        @PathVariable(value = "businessType", required = true) String businessType
    ) {
        ResponseEntity<? super GetReviewBoardLocationBusinessTypeListResponseDto> response = reviewBoardService.getReviewBoardLocationBusinessTypeList(location, businessType);
        return response;
    }

    // API : 기행기 게시물 불러오기 메서드 //
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetReviewBoardResponseDto> getReviewBoard(
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super GetReviewBoardResponseDto> response = reviewBoardService.getReviewBoard(boardNumber);
        return response;
    }

    // API : 기행기 게시물 검색 리스트 불러오기 메서드 //
    @GetMapping("/{searchWord}")
    public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(
        @PathVariable(value = "searchWord", required = true) String searchWord
    ) {
        ResponseEntity<? super GetSearchReviewBoardResponseDto> response = reviewBoardService.getSearchReviewBoard(searchWord);
        return response;
    }

    // API : 특정기행기 게시물 댓글 리스트 불러오기 메서드 //
    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super GetCommentListResponseDto> response = reviewBoardService.getCommentList(boardNumber);
        return response;
    }

    // API : 특정 유저의 기행기 게시물 리스트 불러오기 메서드 //
    @GetMapping("/user-list/{email}")
    public ResponseEntity<? super GetUserReviewBoardListResponseDto> getUserReviewBoardList(
        @PathVariable(value = "email", required = true) String email
    ) {
        ResponseEntity<? super GetUserReviewBoardListResponseDto> response = reviewBoardService.getUserReviewBoardList(email);
        return response;
    }

    // API : 기행기 게시물 작성 메서드 //
    @PostMapping("")
    public ResponseEntity<? super PostReviewBoardResponseDto> postReviewBoard(
        @AuthenticationPrincipal String email,
        @RequestBody @Valid PostReviewBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PostReviewBoardResponseDto> response = reviewBoardService.postReviewBoard(email, requestBody);
        return response;
    }

    // API : 기행기 게시물 댓글 작성 메서드 //
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
        @AuthenticationPrincipal String email,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber,
        @RequestBody @Valid PostCommentRequestDto requestBody
    ) {
        ResponseEntity<? super PostCommentResponseDto> response = reviewBoardService.postComment(boardNumber, email, requestBody);
        return response;
    }

    // API : 기행기 게시물 좋아요 기능 메서드 //
    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
        @AuthenticationPrincipal String email,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super PutFavoriteResponseDto> response = reviewBoardService.putFavorite(boardNumber, email);
        return response;
    }

    // API : 기행기 게시물 수정 메서드 //
    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchReviewBoardResponseDto> patchReviewBoard(
        @AuthenticationPrincipal String email,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber,
        @RequestBody @Valid PatchReviewBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PatchReviewBoardResponseDto> response = reviewBoardService.patchReviewBoard(boardNumber, email, requestBody);
        return response;
    }

    // API : 기행기 게시물 삭제 메서드 //
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteReviewBoardResponseDto> deleteReviewBoard(
        @AuthenticationPrincipal String email,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super DeleteReviewBoardResponseDto> response = reviewBoardService.deleteReviewBoard(boardNumber, email);
        return response;
    }

    // API : 기행기 게시물 댓글 삭제 메서드 //
    @DeleteMapping("/{boardNumber}/comment")
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(
        @AuthenticationPrincipal String email,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super DeleteCommentResponseDto> response = reviewBoardService.deleteComment(boardNumber, email);
        return response;
    }

}
