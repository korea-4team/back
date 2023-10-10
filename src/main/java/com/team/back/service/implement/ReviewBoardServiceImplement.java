package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostCommentRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;
import com.team.back.dto.response.reviewBoard.CommentListResponseDto;
import com.team.back.dto.response.reviewBoard.DeleteCommentResponseDto;
import com.team.back.dto.response.reviewBoard.DeleteReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationBusinessTypeListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardLocationListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.GetUserReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.PatchReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PostCommentResponseDto;
import com.team.back.dto.response.reviewBoard.PostReviewBoardResponseDto;
import com.team.back.dto.response.reviewBoard.PutFavoriteResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.entity.CommentEntity;
import com.team.back.entity.ReviewBoardFavoriteEntity;
import com.team.back.entity.ReviewBoardEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.resultSet.CommentListResultSet;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
import com.team.back.repository.CommentRepository;
import com.team.back.repository.ReviewBoardFavoriteRepository;
import com.team.back.repository.ReviewBoardRepository;
import com.team.back.repository.ReviewBoardViewRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.ReviewBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewBoardServiceImplement implements ReviewBoardService {

    private final ReviewBoardRepository reviewBoardRepository;
    private final ReviewBoardViewRepository reviewBoardViewRepository;
    private final ReviewBoardFavoriteRepository favoriteRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    // 기행기 게시물 리스트 최신순으로 불러오기 //
    @Override
    public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBaordList(Integer section) {
        
        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            // description: 최신 기행기 게시물 리스트 불러오기 //
            Integer limit = (section - 1) * 30;
            List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getReviewBoardList(limit);

            // description: 검색 결과를 ReseponseDto 형태로 변환 //
            reviewBoardList = ReviewBoardListResponseDto.copyList(resultSets);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetReviewBoardListResponseDto.success(reviewBoardList);
    }

    // 기행기 게시물 불러오기 //
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

    // 기행기 게시물 지역별 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetReviewBoardLocationListResponseDto> getReviewBoardLocationList(String location) {

        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            // description: 지역명으로 게시물 조회 //
            List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByLocationOrderByWriteDatetimeDesc(location);

            // description: entity를 dto 형태로 변환 //
            reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetReviewBoardLocationListResponseDto.success(reviewBoardList);      
    }

    // 기행기 게시물 업종별 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetReviewBoardBusinessTypeListResponseDto> getReviewBoardBusinessTypeList(String businessType) {
        
        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            // description: 업종별로 게시물 조회 //
            List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByBusinessTypeOrderByWriteDatetimeDesc(businessType);

            // description: entity를 dto 형태로 변환 //
            reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetReviewBoardBusinessTypeListResponseDto.success(reviewBoardList);
    }

    // 기행기 게시물 지역 및 업종별 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetReviewBoardLocationBusinessTypeListResponseDto> getReviewBoardLocationBusinessTypeList(String location, String businessType) {

        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            // description: 지역 및 업종이 일치하는 게시물 조회 //
            List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByLocationAndBusinessTypeOrderByWriteDatetimeDesc(location, businessType);

            // description: entity를 dto 형태로 변환 //
            reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetReviewBoardLocationBusinessTypeListResponseDto.success(reviewBoardList);
    }

    // 기행기 게시물 댓글리스트 조회 //
    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {
        
        List<CommentListResponseDto> commentList = null;

        try {
            // description: 기행기 게시물의 댓글 리스트 조회 //
            List<CommentListResultSet> resultSets = commentRepository.getCommentList(boardNumber);

            // description: resultSet을 dto로 변환 //
            commentList = CommentListResponseDto.copyList(resultSets);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCommentListResponseDto.success(commentList);
    }

    // 특정 유저의 기행기 게시물 리스트 조회 //
    @Override
    public ResponseEntity<? super GetUserReviewBoardListResponseDto> getUserReviewBoardList(String email) {
        
        List<ReviewBoardListResponseDto> reviewBoardList = null;

        try {
            // description: 특정 이메일에 해당하는 게시물 리스트 조회 //
            List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByWriterEmailOrderByWriteDatetimeDesc(email);

            // description: entity를 dto 형태로 변환 //
            reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserReviewBoardListResponseDto.success(reviewBoardList);
    }

    // 기행기 게시물 작성 //
    @Override
    public ResponseEntity<? super PostReviewBoardResponseDto> postReviewBoard(String writerEmail, PostReviewBoardRequestDto dto) {
        
        try {
            // description: 작성자 이메일이 존재하는 이메일인지 확인 //
            boolean hasUser = userRepository.existsByEmail(writerEmail);
            if (!hasUser) return PostReviewBoardResponseDto.noExistedUser();

            // description: entity 생성 //
            ReviewBoardEntity reviewBoardEntity = new ReviewBoardEntity(writerEmail, dto);

            // description: 데이터베이스에 저장 //
            reviewBoardRepository.save(reviewBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostReviewBoardResponseDto.success();
    }

    // 기행기 게시물 댓글작성 //
    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String userEmail, PostCommentRequestDto dto) {
        
        try {
            // description: 존재하는 회원인지 확인 //
            boolean hasUser = userRepository.existsByEmail(userEmail);
            if (!hasUser) return PostCommentResponseDto.noExistedUser();

            // description: 존재하는 게시물인지 확인 //
            ReviewBoardEntity reviewBoardEntity = reviewBoardRepository.findByBoardNumber(boardNumber);
            if (reviewBoardEntity == null) return PostCommentResponseDto.noExistedBoard();

            // description: Entity 생성 //
            CommentEntity commentEntity = new CommentEntity(boardNumber, userEmail, dto);

            // description: 데이터베이스에 저장 //
            commentRepository.save(commentEntity);

            // description: 게시물 댓글 수 증가 //
            reviewBoardEntity.increaseCommentCount();

            // description: 데이터베이스에 저장 //
            reviewBoardRepository.save(reviewBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostCommentResponseDto.success();
    }

    // 기행기 게시물 추천하기 //
    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String userEmail) {
        
        try {
            // 존재하는 회원인지 확인 //
            boolean hasUser = userRepository.existsByEmail(userEmail);
            if (!hasUser) return PutFavoriteResponseDto.noExistedUser();

            // description: 존재하는 게시물인지 확인 //
            ReviewBoardEntity reviewBoardEntity = reviewBoardRepository.findByBoardNumber(boardNumber);
            if(reviewBoardEntity == null) return PutFavoriteResponseDto.noExistedBoard();

            // description: 해당 유저가 해당 게시물에 추천 했는지 확인 //
            boolean isFavorite = favoriteRepository.existsByUserEmailAndBoardNumber(userEmail, boardNumber);

            // description: Entity 생성 //
            ReviewBoardFavoriteEntity favoriteEntity = new ReviewBoardFavoriteEntity(boardNumber, userEmail);

            // description: 이미 추천 했을 때 //
            if (isFavorite) {
                favoriteRepository.delete(favoriteEntity);
                reviewBoardEntity.decreaseFavoriteCount();
            }
            // description: 아직 추천 하지 않았을 때 //
            else{
                favoriteRepository.save(favoriteEntity);
                reviewBoardEntity.increaseFavoriteCount();
            }
            
            // description: 데이터베이스에 저장 //
            reviewBoardRepository.save(reviewBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PutFavoriteResponseDto.success();
    }


    // 기행기 게시물 수정 //
    @Override
    public ResponseEntity<? super PatchReviewBoardResponseDto> patchReviewBoard(Integer boardNumber, String userEmail, PatchReviewBoardRequestDto dto) {
        
        try {
            // description: 존재하는 유저인지 확인 //
            boolean hasUser = userRepository.existsByEmail(userEmail);
            if (!hasUser) return PatchReviewBoardResponseDto.noExistedUser();

            // description: 존재하는 게시물인지 확인 //
            ReviewBoardEntity reviewBoardEntity = reviewBoardRepository.findByBoardNumber(boardNumber);
            if (reviewBoardEntity == null) return PatchReviewBoardResponseDto.noExistedBoard();

            // description: 작성자 이메일과 입력받은 이메일이 같은지 확인 //
            boolean equalWriter = reviewBoardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter) return PatchReviewBoardResponseDto.noPermission();

            // description: 수정 //
            reviewBoardEntity.patch(dto);

            // description: 데이터베이스에 저장 //
            reviewBoardRepository.save(reviewBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchReviewBoardResponseDto.success();
    }

    // 기행기 게시물 삭제 //
    @Override
    public ResponseEntity<? super DeleteReviewBoardResponseDto> deleteReviewBoard(Integer boardNumber, String userEmail) {
        
        try {
            // description: 존재하는 유저인지 확인 //
            boolean hasUser = userRepository.existsByEmail(userEmail);
            if (!hasUser) return DeleteReviewBoardResponseDto.noExistedUser();

            // description: 존재하는 게시물인지 확인 //
            ReviewBoardEntity reviewBoardEntity = reviewBoardRepository.findByBoardNumber(boardNumber);
            if (reviewBoardEntity == null) return DeleteReviewBoardResponseDto.noExistedBoard();

            // description: 작성자 이메일과 입력받은 이메일이 같은지 확인 //
            boolean equalWriter = reviewBoardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter) return DeleteCommentResponseDto.noPermission();

            // description: 댓글 데이터 삭제 //
            commentRepository.deleteByBoardNumber(boardNumber);

            // description: 추천 데이터 삭제 //
            favoriteRepository.deleteByBoardNumber(boardNumber);

            // description: 기행기 게시글 삭제 //
            reviewBoardRepository.delete(reviewBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteReviewBoardResponseDto.success();
    }

    // 기행기 게시글 댓글 삭제 //
    @Override
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer commentNumber, String userEmail) {
        
        try {
            // description: 존재하는 유저인지 확인 //
            boolean hasUser = userRepository.existsByEmail(userEmail);
            if (!hasUser) return DeleteCommentResponseDto.noExistedUser();

            // description: 존재하는 댓글인지 확인 //
            CommentEntity commentEntity = commentRepository.findByCommentNumber(commentNumber);
            if (commentEntity == null) return DeleteCommentResponseDto.noExistedComment();

            // description: 작성자 이메일과 입력받은 이메일이 같은지 확인 //
            boolean equalWriter = commentEntity.getUserEmail().equals(userEmail);
            if (!equalWriter) return DeleteCommentResponseDto.noPermission();

            // description: 댓글 데이터 삭제 //
            commentRepository.deleteByCommentNumber(commentNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteCommentResponseDto.success();
    }
    
}
