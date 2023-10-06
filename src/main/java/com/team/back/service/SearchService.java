package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.search.GetSearchResponseDto;

public interface SearchService {
    ResponseEntity<? super GetSearchResponseDto> getSearchBoard(String searchWord, String location);
    ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(String searchWord, String location, Integer section);
    ResponseEntity<? super GetAdvertisingboardResponseDto> getSearchAdvertisingBoard(String searchWord, String loaction, Integer section);
}
