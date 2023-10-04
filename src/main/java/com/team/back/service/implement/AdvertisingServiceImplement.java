package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertisingResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;
import com.team.back.service.AdvertisingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdvertisingServiceImplement implements AdvertisingService{@Override
    public ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(Integer boardNumber,
            String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAdvertisingBoard'");
    }

    @Override
    public ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertsingBoard(
            Integer boardNumber, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteShortCommentAdvertsingBoard'");
    }

    @Override
    public ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdvertisingboard'");
    }

    @Override
    public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(Integer section) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentAdvertisingBoard'");
    }

    @Override
    public ResponseEntity<? super GetSearchAdvertisingBoardResponseDto> getSearchAdvertisingBoard(String searchWord) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchAdvertisingBoard'");
    }

    @Override
    public ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShortReviewList'");
    }

    @Override
    public ResponseEntity<? super GetUserListAdvertisingResponseDto> getUserListAdvertising(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserListAdvertising'");
    }

    @Override
    public ResponseEntity<? super PatchAdvertisingBoardResponseDto> patchAdvertisingBoard(Integer boardNumber,
            String email, PatchAdvertisingBoardResponseDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchAdvertisingBoard'");
    }

    @Override
    public ResponseEntity<? super PostAdvertisingBoardResponseDto> postAdvertisingBoard(Integer boardNumber,
            String email, PostAdvertisingRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postAdvertisingBoard'");
    }

    @Override
    public ResponseEntity<? super PostShortReviewResponseDto> postShortReview(Integer boardNumber, String email,
            PostAdvertisingRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postShortReview'");
    }
    
}
