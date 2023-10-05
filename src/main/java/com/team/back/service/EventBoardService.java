package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.eventBoard.PatchEventBoardRequestDto;
import com.team.back.dto.request.eventBoard.PostEventBoardRequestDto;
import com.team.back.dto.response.eventBoard.DeleteEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardListResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PatchEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PostEventBoardResponseDto;

public interface EventBoardService {
    
    // 이벤트 게시물 리스트 불러오기 //
    ResponseEntity<? super GetEventBoardListResponseDto> getEventBoardList(Integer section);
    // 이벤트 게시물 상세보기 //
    ResponseEntity<? super GetEventBoardResponseDto> getEventBoard(Integer boardNumber);
    // 이벤트 게시물 작성 //
    ResponseEntity<? super PostEventBoardResponseDto> postEventBoard(String adminId, PostEventBoardRequestDto dto);
    // 이벤트 게시물 수정 //
    ResponseEntity<? super PatchEventBoardResponseDto> patchEventBoard(Integer boardNumber, String adminId, PatchEventBoardRequestDto dto);
    // 이벤트 게시물 삭제 //
    ResponseEntity<? super DeleteEventBoardResponseDto> deleteEventBoard(Integer boardNumber, String adminId);
}
