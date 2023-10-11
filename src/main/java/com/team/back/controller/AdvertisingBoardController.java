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

import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostShortReviewRequestDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardLocationListResponsedto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostReservationResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;
import com.team.back.dto.response.advertisingBoard.PutAdvertisingFavoriteListResponseDto;
import com.team.back.service.AdvertisingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/advertising-board")
@RequiredArgsConstructor
public class AdvertisingBoardController {

  private final AdvertisingService advertisingService;

  // 게시물 불러오기
  @GetMapping("/board-list/{boardNumber}")
  public ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(
    @PathVariable(value="boardNumber", required = true) Integer boardNumber
  ) {
    ResponseEntity<? super GetAdvertisingboardResponseDto> response = advertisingService.getAdvertisingboard(boardNumber);
    return response;
  }

  // 최신 게시물 리스트 불러오기
  @GetMapping("/current-board/{section}")
  public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(
    @PathVariable(value = "section", required = true) Integer section
  ) {
    ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> response = advertisingService.getCurrentAdvertisingBoard(section);
    return response;
  }


  // 특정 게시물의 좋아요 기능 메서드
  @GetMapping("/detail/{board-number}/favorite")
  public ResponseEntity<? super PutAdvertisingFavoriteListResponseDto> advertisingFavoriteList(
    @AuthenticationPrincipal String writerEmail,
    @PathVariable(value = "boardNumber", required = true) Integer boardNumber
  ) {
    ResponseEntity<? super PutAdvertisingFavoriteListResponseDto> response = advertisingService.putAdvertisingFavoriteList(boardNumber,writerEmail);
    return response;
  }
  // 특정 게시물 지역별 리스트 불러오기
  @GetMapping("/board-list/location/{location}")
  public ResponseEntity<? super GetAdvertisingBoardLocationListResponsedto> getAdvertisingBoardLocationList(
    @PathVariable(value = "location", required = true) String location
  ) {
    ResponseEntity<? super GetAdvertisingBoardLocationListResponsedto> response = advertisingService.getAdvertisingBoardLocationList(location);
    return response;
  }

  // 업종별 리스트 불러오기
  @GetMapping("/{business-Type}")
  public ResponseEntity<? super GetAdvertisingBoardBusinessTypeListResponseDto> getAdvertisingBoardBusinessTypeList(
    @PathVariable(value = "businessType",required = true) String businessTypeString
  ) {
    ResponseEntity<? super GetAdvertisingBoardBusinessTypeListResponseDto> response = advertisingService.getAdvertisingBoardBusinessTypeList(businessTypeString);
    return response;
  }

  //한줄 리뷰 작성
  @PostMapping("/detail/{boardNumber}/short-review")
  public ResponseEntity<? super PostShortReviewResponseDto> postShortReviewList(
    @AuthenticationPrincipal String email,
    @PathVariable(value = "boardNumber",required = true) Integer boardNumber,
    @RequestBody @Valid PostShortReviewRequestDto requestBody
  ) {
    ResponseEntity<? super PostShortReviewResponseDto> response = advertisingService.postShortReview(boardNumber, email, requestBody);
    return response;

  }

  //게시글 작성
  @PostMapping("/write")
  public ResponseEntity<? super PostAdvertisingBoardResponseDto> postAdvertisingBoard(
    @AuthenticationPrincipal String email,
    @RequestBody @Valid PostAdvertisingRequestDto requestDto
  ){
    ResponseEntity<? super PostAdvertisingBoardResponseDto> response = advertisingService.postAdvertisingBoard(email, requestDto);
    return response;
  }

  // 게시글 수정
  @PatchMapping("/update/{board_number}")
  public ResponseEntity<? super PatchAdvertisingBoardResponseDto> patchAdvertisingBoard(
    @AuthenticationPrincipal String email,
    @PathVariable(value = "boardNumber",required = true) Integer boardNumber,
    @RequestBody @Valid PatchAdvertisingRequestDto requestDto
  ){
    ResponseEntity<? super PatchAdvertisingBoardResponseDto> response = advertisingService.patchAdvertisingBoard(boardNumber, email, requestDto);
    return response;
  }

  //게시글 삭제
  @DeleteMapping("/delete/{board_number}")
  public ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(
    @AuthenticationPrincipal String email,
    @PathVariable(value = "boardNumber",required = true) Integer boardNumber
    
  ){
    ResponseEntity<? super DeleteAdvertisingBoardResponseDto> response = advertisingService.deleteAdvertisingBoard(boardNumber, email);
    return response;
  }

  // 한줄 리뷰 삭제
  @DeleteMapping("/detail/{board_number}/short-review/delete")
  public ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertisingBoard(
    @AuthenticationPrincipal String email,
    @PathVariable(value = "boardNumber",required = true) Integer boardNumber
  ) {
    ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> response = advertisingService.deleteShortCommentAdvertsingBoard(boardNumber, email);
    return response;
  }

  // //메뉴 등록
  // @PostMapping("/write/{boardNumber}/menu-list")
  // public ResponseEntity<? super PostAdvertisingBoardMenuListResponseDto> postAdvertisingBoardMenuList(
  //   @AuthenticationPrincipal String email,
  //   @PathVariable(value = "boardNumber",required = true) Integer boardNumber
  // ) {
  //   ResponseEntity<? super PostAdvertisingBoardMenuListResponseDto> response = advertisingService.postAdvertisingBoardMenuList(boardNumber, email);
  //   return response;
  // }

  //예약
  @PostMapping("/detail/{board_number}/reservation")
  public ResponseEntity<? super PostReservationResponseDto> postReservation(
    @AuthenticationPrincipal String email,
    @PathVariable(value = "boardNumber",required = true) Integer boarNumber
  ){
    ResponseEntity<? super PostReservationResponseDto> response = advertisingService.postReservation(boarNumber, email, email, 0);
    return response;
  }


    
  
  
}
