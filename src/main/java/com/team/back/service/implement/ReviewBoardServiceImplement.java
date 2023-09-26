package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;
import com.team.back.dto.response.reviewBoard.DeleteCommentResponseDto;
import com.team.back.dto.response.reviewBoard.DeleteReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetSearchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetUserReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.PatchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PostCommentResponseDto;
import com.team.back.dto.response.reviewBoard.PostReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PutFavoriteResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.entity.ReviewBoardEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
import com.team.back.repository.ReviewBoardRepository;
import com.team.back.repository.ReviewBoardViewRepository;
import com.team.back.service.ReviewBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewBoardServiceImplement implements ReviewBoardService {

    private final ReviewBoardRepository reviewBoardRepository;
    private final ReviewBoardViewRepository reviewBoardViewRepository;

    @Override
    public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBaordList(Integer section) {
        
        List<ReviewBoardListResponseDto> boardList = null;

        try {
            // description: 최신 기행기 게시물 리스트 불러오기 //
            Integer limit = (section - 1) * 50;
            List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getReviewBoardList(limit);

            // description: 검색 결과를 ReseponseDto 형태로 변환 //
            boardList = ReviewBoardListResponseDto.copyList(resultSets);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetReviewBoardListResponseDto.success(boardList);
    }

    @Override
    public ResponseEntity<? super GetReviewBoardResponseDto> getReviewBoard(Integer boardNumber) {
        
        ReviewBoardViewEntity reviewBoardViewEntity = null;

        try {
            // description: 게시물 번호에 해당하는 게시물 조회 //
            reviewBoardViewEntity = reviewBoardViewRepository.findByBoardNumber(boardNumber);

            // description: 존재하는 게시물인지 확인 //
            if (reviewBoardViewEntity == null) return GetReviewBoardResponseDto.noExistedBoard();

            // description: 게시물 조회수 증가 //
            ReviewBoardEntity reviewBoardEntity = reviewBoardRepository.findByBoardNumber(boardNumber);
            reviewBoardEntity.increaseViewCount();

            // description: 데이터베이스에 저장 //
            reviewBoardRepository.save(reviewBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetReviewBoardResponseDto.success(reviewBoardViewEntity);
    }

    @Override
    public ResponseEntity<? super GetReviewBoardLocationListResponseDto> getReviewBoardLocationList(String location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewBoardLocationList'");
    }

    @Override
    public ResponseEntity<? super GetReviewBoardBusinessTypeListResponseDto> getReviewBoardBusinessTypeList(
            String businessType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewBoardBusinessTypeList'");
    }

    @Override
    public ResponseEntity<? super GetReviewBoardLocationBusinessTypeListResponseDto> getReviewBoardLocationBusinessTypeList(
            String location, String businessType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewBoardLocationBusinessTypeList'");
    }

    @Override
    public ResponseEntity<? super GetSearchReviewBoardResponseDto> getSearchReviewBoard(String searchWord) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchReviewBoard'");
    }

    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentList'");
    }

    @Override
    public ResponseEntity<? super GetUserReviewBoardListResponseDto> getUserReviewBoardList(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserReviewBoardList'");
    }

    @Override
    public ResponseEntity<? super PostReviewBoardResponseDto> postReviewBoard(String email,
            PostReviewBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postReviewBoard'");
    }

    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String email,
            PostCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putFavorite'");
    }

    @Override
    public ResponseEntity<? super PatchReviewBoardResponseDto> patchReviewBoard(Integer boardNumber, String email,
            PatchReviewBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchReviewBoard'");
    }

    @Override
    public ResponseEntity<? super DeleteReviewBoardResponseDto> deleteReviewBoard(Integer boardNumber, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReviewBoard'");
    }

    @Override
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer boardNumber, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteComment'");
    }
    
}
