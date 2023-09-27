package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.noticeBoard.PatchNoticeBoardRequestDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.noticeBoard.DeleteNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.GetNoticeBoardListResponseDto;
import com.team.back.dto.response.noticeBoard.GetNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.PatchNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.PostNoticeBoardResponseDto;

public interface NoticeBoardService {

	// 공지사항 게시물 리스트 불러오기 메서드
	ResponseEntity<? super GetNoticeBoardListResponseDto> getNoticeBoardList();

	// 공지사항 게시물 상세보기 메서드
	ResponseEntity<? super GetNoticeBoardResponseDto> getNoticeBoard(Integer boardNumber);

	// 공지사항 게시물 작성 메서드
	ResponseEntity<? super PostNoticeBoardResponseDto> postNoticeBoard(String adminId, PostNoticeBoardRequestDto dto);

	// 공지사항 게시물 수정 메서드
	ResponseEntity<? super PatchNoticeBoardResponseDto> patchNoticeBoard(Integer boardNumber, String adminId, PatchNoticeBoardRequestDto dto);

	// 공지사항 게시물 삭제 메서드
	ResponseEntity<? super DeleteNoticeBoardResponseDto> deleteNoticeBoard(Integer boardNumber, String adminId);
}
