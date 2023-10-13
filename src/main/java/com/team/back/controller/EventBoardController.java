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

import com.team.back.dto.request.eventBoard.PatchEventBoardRequestDto;
import com.team.back.dto.request.eventBoard.PostEventBoardRequestDto;
import com.team.back.dto.response.eventBoard.DeleteEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardListResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PatchEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PostEventBoardResponseDto;
import com.team.back.service.EventBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/event-board")
@RequiredArgsConstructor
public class EventBoardController {
    
    private final EventBoardService eventBoardService;

    // API: 이벤트 게시물 최신순으로 불러오기 //
    @GetMapping("/board-list/{section}")
    public ResponseEntity<? super GetEventBoardListResponseDto> getEventBoardList (
        @PathVariable(value = "section", required = true) Integer section
    ) {
        ResponseEntity<? super GetEventBoardListResponseDto> response = eventBoardService.getEventBoardList(section);
        return response;
    }

    // API: 이벤트 게시물 상세보기 //
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetEventBoardResponseDto> getEventBoard(
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super GetEventBoardResponseDto> response = eventBoardService.getEventBoard(boardNumber);
        return response;
    }

    // API: 이벤트 게시물 작성 //
    @PostMapping("")
    public ResponseEntity<? super PostEventBoardResponseDto> postEventBoard(
        @AuthenticationPrincipal String adminId,
        @RequestBody @Valid PostEventBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PostEventBoardResponseDto> response = eventBoardService.postEventBoard(adminId, requestBody);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchEventBoardResponseDto> patchEventBoard(
        @AuthenticationPrincipal String adminId,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber,
        @RequestBody @Valid PatchEventBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PatchEventBoardResponseDto> response = eventBoardService.patchEventBoard(boardNumber, adminId, requestBody);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteEventBoardResponseDto> deleteEventBoard(
        @AuthenticationPrincipal String adminId,
        @PathVariable(value = "boardNumber", required = true) Integer boardNumber
    ) {
        ResponseEntity<? super DeleteEventBoardResponseDto> response = eventBoardService.deleteEventBoard(boardNumber, adminId);
        return response;
    }
}
