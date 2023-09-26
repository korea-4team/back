package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;

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
import com.team.back.service.ReviewBoardService;

public class ReviewBoardServiceImplement implements ReviewBoardService {

    @Override
    public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardCurrentList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewBoardList'");
    }

    @Override
    public ResponseEntity<? super GetReviewBoardResponseDto> getReviewBoard(Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReviewBoard'");
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
