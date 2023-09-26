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
@RequiredArgsConstructor
public class AdvertisingBoardController {

  private final AdvertisingService advertisingService;

  @GetMapping("/advertising-board-list")
  public static void GetAdvertisingBoard() {

  }

  @GetMapping("/advertising-board-list")
  public static void GetCurrentAdvertisingBoard() {

  }
  @GetMapping
  public static void GetSearchAdvertisingBoard() {

  }
  @GetMapping
  public static void GetShortReviewList() {

  }
  @GetMapping
  public static void GetUserListAdvertising() {

  }

  @PatchMapping
  public static void PatchAdvertisingBoard() {

  }
  @PostMapping
  public static void PostAdvertisingBoard() {

  }
  @DeleteMapping
  public static void DeleteAdvertisingBoard() {

  }
  @DeleteMapping
  public static void DeleteShortCommentAdvertisingBoard() {
    
  }
  
}
