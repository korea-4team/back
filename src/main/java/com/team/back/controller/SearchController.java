package com.team.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.search.GetSearchResponseDto;
import com.team.back.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    
    private final SearchService searchService;
    

    @GetMapping(value = {"/{searchWord}", "/{location}/{searchWord}"})
    public ResponseEntity<? super GetSearchResponseDto> getSearchBoard(
        @PathVariable(value = "searchWord", required = true) String searchWord,
        @PathVariable(value = "location", required = false) String location
    ) {
        ResponseEntity<? super GetSearchResponseDto> response = searchService.getSearchBoard(searchWord, location);
        return response;
    }

    @GetMapping(value = {"/review-board/{searchWord}/{section}", "/review-board/{location}/{searchWord}/{section}"})
    public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(
        @PathVariable(value = "searchWord", required = true) String searchWord,
        @PathVariable(value = "location", required = false) String location,
        @PathVariable(value = "section", required = true) Integer section
    ) {
        ResponseEntity<? super GetSearchReviewBoardResponseDto> response = searchService.getSearchReviewBoard(searchWord, location, section);
        return response;
    }

    // API : 기행기 게시물 검색 리스트 불러오기 메서드 //
//     @GetMapping("/{searchWord}")
//     public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(
//         @PathVariable(value = "searchWord", required = true) String searchWord
//     ) {
//         ResponseEntity<? super GetSearchReviewBoardResponseDto> response = searchService.getSearchReviewBoard(searchWord);
//         return response;
//     }
}
