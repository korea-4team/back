package com.team.back.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.service.AdvertisingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/advertising-board")
// @RequiredArgsConstructor
public class AdvertisingBoardController {

  // private final AdvertisingService advertisingService;

  @GetMapping("/advertising-board/board-list")
  public static void GetAdvertisingBoard() {

  }

  // @GetMapping("/advertising-board/board-list")
  // public static void GetCurrentAdvertisingBoard() {

  // }
  
  @PostMapping("/advertising-board/detail/{boardNumber}/short-review")
  public static void PostShortReviewList() {

  }
  @PatchMapping("/advertising-board/update/{boardNumber}")
  public static void PatchAdvertisingBoard() {

  }
  @PostMapping("/advertising-board/write/menu-list")
  public static void PostAdvertisingBoard() {

  }
  @DeleteMapping("/advertising-board/delete/{boardNumber}")
  public static void DeleteAdvertisingBoard() {

  }
  @DeleteMapping("/advertising-board/delete/{boardNumber}/short-review")
  public static void DeleteShortCommentAdvertisingBoard() {
    
  }
  @PostMapping("/advertising-board/detail/{boardNumber}/reservation")
  public static void ReservationAdvertisingBoard(){
    
  }
  
}
