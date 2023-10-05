// package com.team.back.controller;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
// import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
// import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoardResponseDto;
// import com.team.back.service.AdvertisingService;

// import lombok.RequiredArgsConstructor;


// @RestController
// @RequestMapping("/advertising-board")
// @RequiredArgsConstructor
// public class AdvertisingBoardController {

//   private final AdvertisingService advertisingService;

//   // 게시물 불러오기
//   @GetMapping("/board-list")
//   public ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(
//     @PathVariable(value="boardNumber", required = true) Integer boardNumber
//   ) {
//     ResponseEntity<? super GetAdvertisingboardResponseDto> response = advertisingService.getAdvertisingboard(boardNumber);
//     return response;
//   }

//   // 최신 게시물 리스트 불러오기
//   @GetMapping("/current-board/{section}")
//   public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(
//     @PathVariable(value = "section", required = true) Integer section
//   ) {
//     ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> response = advertisingService.getCurrentAdvertisingBoard(section);
//     return response;
//   }

//   // 검색 게시물 리스트 불러오기 
//   @GetMapping("/search/{searchWord}")
//   public ResponseEntity<? super GetSearchAdvertisingBoardResponseDto> getSearchAdvertisingBoard(
//     @PathVariable(value = "searchWord", required = true) String searchWord
//   ) {
//     ResponseEntity<? super GetSearchAdvertisingBoardResponseDto> response = advertisingService.getSearchAdvertisingBoard(searchWord);
//     return response;

//   }

    
  
  
// }
