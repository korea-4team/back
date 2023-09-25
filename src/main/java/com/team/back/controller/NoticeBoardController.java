package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.noticeBoard.PostNoticeBoardResponseDto;
import com.team.back.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice-board")
@RequiredArgsConstructor
public class NoticeBoardController {

	private final NoticeBoardService noticeBoardService;
	
	// 공지사항 게시물 리스트 불러오기 메서드
	@GetMapping("/notice-board-list")
  public static void GetNoticeBoardList() {
		
	}

	// 공지사항 게시물 상세보기 메서드
	@GetMapping("/detail/{boardNumber}")
	public static void GetNoticeBoard() {

	}

	// 공지사항 작성 메서드
	@PostMapping("/write")
	public ResponseEntity<? super PostNoticeBoardResponseDto> postNoticeBoard(
		@AuthenticationPrincipal String adminId, @RequestBody @Valid PostNoticeBoardRequestDto requestBody
	) {
		ResponseEntity<? super PostNoticeBoardResponseDto> response = noticeBoardService.postBoard(adminId, requestBody);
		return response;
	}
	
	// 공지사항 수정 메서드
	@PatchMapping("/update/{boardNumber}")
	public static void patchNoticeBoard() {

	}


	// 공지사항 삭제 메서드
	@DeleteMapping("/delete/{boardNumber}")
	public static void deleteNoticeBoard() {

	}

}
