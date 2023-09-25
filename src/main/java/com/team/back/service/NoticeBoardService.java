package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.noticeBoard.PostNoticeBoardResponseDto;

public interface NoticeBoardService {
	// 공지사항 게시물 작성 메서드
	ResponseEntity<? super PostNoticeBoardResponseDto> postBoard(String adminId, PostNoticeBoardRequestDto dto);
}
