package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.advertisingBoard.AdvertisingBoardListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.dto.response.search.GetSearchResponseDto;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.AdvertisingBoardViewRespository;
import com.team.back.repository.ReviewBoardRepository;
import com.team.back.repository.ReviewBoardViewRepository;
import com.team.back.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final ReviewBoardViewRepository reviewBoardViewRepository;
    private final AdvertisingBoardViewRespository advertisingBoardViewRespository;
    private final ReviewBoardRepository reviewBoardRepository;
    private final AdvertisingBoardRepository advertisingBoardRepository;

    // 검색 게시물 최신 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetSearchResponseDto> getSearchBoard(String searchWord, String loaction) {

        List<ReviewBoardListResponseDto> reviewBoardList = null;
        List<AdvertisingBoardListResponseDto> advertisingBoardList = null;

        try {
            if (loaction == null) {
                List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByTitleContainsOrContentsContainsOrBusinessTypeContainsOrTagWordContainsOrderByWriteDatetimeDesc(searchWord, searchWord, searchWord, searchWord);
                advertisingBoardList = AdvertisingBoardListResponseDto.copyEntityList(advertisingViewEntities);
                List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByTitleContainsOrContentsContainsOrBusinessTypeContainsOrderByWriteDatetimeDesc(searchWord, searchWord, searchWord);
                reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            } else {
                List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByTitleContainsOrContentsContainsOrLocationOrBusinessTypeContainsOrTagWordContainsOrderByWriteDatetimeDesc(searchWord, searchWord, loaction, searchWord, searchWord);
                advertisingBoardList = AdvertisingBoardListResponseDto.copyEntityList(advertisingViewEntities);
                List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByTitleContainsOrContentsContainsOrLocationOrBusinessTypeContainsOrderByWriteDatetimeDesc(searchWord, searchWord, searchWord, loaction);
                reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSearchResponseDto.success(reviewBoardList, advertisingBoardList);

    }

    // 광고게시판 검색 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetSearchAdvertisingBoardResponseDto> getSearchAdvertisingBoard(String searchWord, String location, Integer section) {
        
        List<AdvertisingBoardListResponseDto> advertisingBoardList = null;

        try {
            if (location == null) {
                Integer limit = (section - 1) * 30;
                List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdvertisingBoardList(searchWord, limit);
                advertisingBoardList = AdvertisingBoardListResponseDto.copyList(resultSets);
            } else {
                Integer limit = (section - 1) * 30;
                List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdvertisingBoardList(searchWord, location, limit);
                advertisingBoardList = AdvertisingBoardListResponseDto.copyList(resultSets);
            }
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSearchAdvertisingBoardResponseDto.success(advertisingBoardList);

    }

    // 기행기게시판 검색 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(String searchWord, String location, Integer section) {
        
        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            if (location == null) {
                Integer limit = (section - 1) * 30;
                List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getReviewBoardList(searchWord, limit);
                reviewBoardList = ReviewBoardListResponseDto.copyList(resultSets);
            }else {
                Integer limit = (section - 1) * 30;
                List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getReviewBoardList(searchWord, location, limit);
                reviewBoardList = ReviewBoardListResponseDto.copyList(resultSets);
            }
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSearchReviewBoardResponseDto.success(reviewBoardList);

    }
}
