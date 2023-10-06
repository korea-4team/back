package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.admin.AdvertisingListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.dto.response.search.GetSearchResponseDto;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
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

    @Override
    public ResponseEntity<? super GetSearchResponseDto> getSearchBoard(String searchWord, String loaction) {

        List<ReviewBoardListResponseDto> reviewBoardList = null;
        List<AdvertisingListResponseDto> advertisingBoardList = null;

        try {
            if (loaction == null) {
                List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByTitleContainsOrBusinessTypeOrTagWordOrderByWriteDatetimeDesc(searchWord, searchWord, searchWord);
                advertisingBoardList = AdvertisingListResponseDto.copyEntityList(advertisingViewEntities);
                List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByTitleContainsOrBusinessTypeOrderByWriteDatetimeDesc(searchWord, searchWord);
                reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            } else {
                List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByTitleContainsOrLocationOrBusinessTypeOrTagWordOrderByWriteDatetimeDesc(searchWord, loaction, searchWord, searchWord);
                advertisingBoardList = AdvertisingListResponseDto.copyEntityList(advertisingViewEntities);
                List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByTitleContainsOrLocationOrBusinessTypeOrderByWriteDatetimeDesc(searchWord, searchWord, loaction);
                reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSearchResponseDto.success(reviewBoardList, advertisingBoardList);

    }

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

    @Override
    public ResponseEntity<? super GetAdvertisingboardResponseDto> getSearchAdvertisingBoard(String searchWord,
            String loaction, Integer section) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchAdvertisingBoard'");
    }

    // 기행기 게시물 검색 //
    // @Override
    // public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(String searchWord) {
        
    //     List<ReviewBoardListResponseDto> reviewBoardList = null;

    //     try {
    //         // description: 검색어가 제목과 지역, 업종에 포함되어있는 게시물 조회 //
    //         List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByTitleContainsOrLocationOrBusinessTypeOrderByWriteDatetimeDesc(searchWord, searchWord, searchWord);

    //         // description: entity를 dto 형태로 전환 //
    //         reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            
    //     } catch (Exception exception) {
    //         exception.printStackTrace();
    //         return ResponseDto.databaseError();
    //     }
    //     return GetSearchReviewBoardResponseDto.success(reviewBoardList);
    // }
    
}
