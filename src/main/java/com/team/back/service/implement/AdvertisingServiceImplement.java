package com.team.back.service.implement;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostShortReviewRequestDto;
import com.team.back.dto.response.advertisingBoard.AdvertisingBoardListResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardLocationListResponsedto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetSearchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertisingResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardMenuListResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostReservationResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;
import com.team.back.dto.response.advertisingBoard.PutAdvertisingFavoriteListResponseDto;
import com.team.back.entity.AdvertisingBoardEntity;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.AdvertisingBoardViewRespository;
import com.team.back.repository.FavoriteRepository;
import com.team.back.repository.ShortReviewAdvertisingBoardRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.AdvertisingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdvertisingServiceImplement implements AdvertisingService{
    
    private final UserRepository userRepository;
    private final AdvertisingBoardRepository advertisingBoardRepository;
    private final FavoriteRepository favoriteRepository;
    private final ShortReviewAdvertisingBoardRepository shortReviewAdvertisingBoardRepository;
    private final AdvertisingBoardViewRespository advertisingBoardViewRespository;
    
    
    
    //게시글 삭제
    @Override
    public ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(Integer boardNumber,
            String email) {
       try{
            //유저가 아닐때
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser) return DeleteAdvertisingBoardResponseDto.noExistedBoard();

            //게시물이 없을때
            AdvertisingBoardEntity advertisingViewEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingViewEntity == null) return DeleteAdvertisingBoardResponseDto.noExistedBoard();

            //작성자 이메일과 입력받은 이메일이 같은가
            boolean equalWriter = advertisingViewEntity.getWriter_email().equals(email);
            if (!equalWriter) return DeleteAdvertisingBoardResponseDto.noPerMission();

            //댓글 데이터 삭제
            shortReviewAdvertisingBoardRepository.deleteByBoardNumber(boardNumber);
            //좋아요 데이터 삭제
            favoriteRepository.deleteByBoardNumber(boardNumber);
            //게시물 삭제
            advertisingBoardRepository.delete(advertisingViewEntity);


       } catch (Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
       }

       return DeleteAdvertisingBoardResponseDto.success();



    }

    // 한줄리뷰 삭제
    @Override
    public ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertsingBoard(
            Integer boardNumber, String email) {
       try{
            //유저가 아닐때
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser) return DeleteShortCommentAdvertisingBoardResponseDto.noExistedBoard();

            //게시물이 없을때
            AdvertisingBoardEntity advertisingViewEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingViewEntity == null) return DeleteShortCommentAdvertisingBoardResponseDto.noExistedBoard();

            //작성자 이메일과 입력받은 이메일이 같은가
            boolean equalWriter = advertisingViewEntity.getWriter_email().equals(email);
            if (!equalWriter) return DeleteShortCommentAdvertisingBoardResponseDto.noPerMission();

            //댓글 데이터 삭제
            shortReviewAdvertisingBoardRepository.deleteByBoardNumber(boardNumber);


       } catch (Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
       }

       return DeleteShortCommentAdvertisingBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(Integer boardNumber) {
        
        AdvertisingViewEntity advertisingViewEntity = null;

        try{
            // 게시물 번호에 해당하는  게시물 조회
            advertisingViewEntity = advertisingBoardViewRespository.findByBoardNumber(boardNumber);
            // 존재하는 게시물인지 확인
            if(advertisingViewEntity == null) return GetAdvertisingboardResponseDto.noExistedBoard();
            //게시물 조회수 증가
            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            advertisingBoardEntity.increaseCommentCount();
            //데이터 베이스에 저장
            advertisingBoardRepository.save(advertisingBoardEntity);

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetAdvertisingboardResponseDto.success(advertisingViewEntity);
    }

    @Override
    public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(Integer section) {

        List<AdvertisingBoardListResponseDto> advertisingBoardList = null;

        try{
            //리스트 불러오기
            Integer limit = (section - 1 ) * 30;
            List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdvertisingBoardList(limit);

            // 검색결과 responsedto로 변환
            advertisingBoardList = AdvertisingBoardListResponseDto.copyList(resultSets);
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCurrentAdvertisingBoardResponseDto.success(advertisingBoardList);
        
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
            String email, PatchAdvertisingRequestDto requestDto) {
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
            PostShortReviewRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postShortReview'");
    }

    @Override
    public ResponseEntity<? super PutAdvertisingFavoriteListResponseDto> putAdvertisingFavoriteList(
            Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAdvertisingFavoriteList'");
    }

    @Override
    public ResponseEntity<? super GetAdvertisingBoardLocationListResponsedto> getAdvertisingBoardLocationList(
            String location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdvertisingBoardLocationList'");
    }

    @Override
    public ResponseEntity<? super GetAdvertisingBoardBusinessTypeListResponseDto> getAdvertisingBoardBusinessTypeList(
            String businessType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdvertisingBoardBusinessTypeList'");
    }

    @Override
    public ResponseEntity<? super PostAdvertisingBoardMenuListResponseDto> postAdvertisingBoardMenuList(
            Integer boardNumber, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postAdvertisingBoardMenuList'");
    }

    @Override
    public ResponseEntity<? super PostReservationResponseDto> postReservation(Integer boardNumber, String email,
            String time, int people) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postReservation'");
    }

}
