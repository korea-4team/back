package com.team.back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingMenuRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostShortReviewRequestDto;
import com.team.back.dto.request.advertisingBoard.PostTagRequestDto;
import com.team.back.dto.response.admin.AdvertisingListResponseDto;
import com.team.back.dto.response.advertisingBoard.AdvertisingBoardListResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.DeleteShortCommentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardBusinessTypeListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingBoardLocationListResponsedto;
import com.team.back.dto.response.advertisingBoard.GetAdvertisingboardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetUserListAdvertisingResponseDto;
import com.team.back.dto.response.advertisingBoard.PatchAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.PostReservationResponseDto;
import com.team.back.dto.response.advertisingBoard.PostShortReviewResponseDto;
import com.team.back.dto.response.advertisingBoard.PutAdvertisingFavoriteListResponseDto;
import com.team.back.dto.response.advertisingBoard.ShortReviewResponseDto;
import com.team.back.entity.AdvertisingBoardEntity;
import com.team.back.entity.AdvertisingBoardFavoriteEntity;
import com.team.back.entity.AdvertisingMenuEntity;
import com.team.back.entity.AdvertisingShortReviewEntity;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.TagEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;
import com.team.back.entity.resultSet.ShortReviewResultSet;
import com.team.back.repository.AdvertisingBoardFavoriteRepository;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.AdvertisingBoardViewRespository;
import com.team.back.repository.AdvertisingMenuRepository;
import com.team.back.repository.ShortReviewAdvertisingBoardRepository;
import com.team.back.repository.TagRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.AdvertisingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdvertisingServiceImplement implements AdvertisingService {

    private final UserRepository userRepository;
    private final AdvertisingBoardRepository advertisingBoardRepository;
    private final AdvertisingBoardFavoriteRepository advertisingBoardFavoriteRepository;
    private final ShortReviewAdvertisingBoardRepository shortReviewAdvertisingBoardRepository;
    private final AdvertisingBoardViewRespository advertisingBoardViewRespository;
    private final AdvertisingMenuRepository advertisingMenuRepository;
    private final TagRepository tagRepository;

    // 게시글 삭제
    @Override
    public ResponseEntity<? super DeleteAdvertisingBoardResponseDto> deleteAdvertisingBoard(Integer boardNumber,
            String email) {
        try {
            // 유저가 아닐때
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser)
                return DeleteAdvertisingBoardResponseDto.noExistedBoard();

            // 게시물이 없을때
            AdvertisingBoardEntity advertisingViewEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingViewEntity == null)
                return DeleteAdvertisingBoardResponseDto.noExistedBoard();

            // 작성자 이메일과 입력받은 이메일이 같은가
            boolean equalWriter = advertisingViewEntity.getWriterEmail().equals(email);
            if (!equalWriter)
                return DeleteAdvertisingBoardResponseDto.noPerMission();

            // 댓글 데이터 삭제
            shortReviewAdvertisingBoardRepository.deleteByBoardNumber(boardNumber);
            // 좋아요 데이터 삭제
            advertisingBoardFavoriteRepository.deleteByBoardNumber(boardNumber);
            // 게시물 삭제
            advertisingBoardRepository.delete(advertisingViewEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteAdvertisingBoardResponseDto.success();

    }

    // 한줄리뷰 삭제
    @Override
    public ResponseEntity<? super DeleteShortCommentAdvertisingBoardResponseDto> deleteShortCommentAdvertsingBoard(
            Integer boardNumber, String email) {
        try {
            // 유저가 아닐때
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser)
                return DeleteShortCommentAdvertisingBoardResponseDto.noExistedBoard();

            // 게시물이 없을때
            AdvertisingBoardEntity advertisingViewEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingViewEntity == null)
                return DeleteShortCommentAdvertisingBoardResponseDto.noExistedBoard();

            // 작성자 이메일과 입력받은 이메일이 같은가
            boolean equalWriter = advertisingViewEntity.getWriterEmail().equals(email);
            if (!equalWriter)
                return DeleteShortCommentAdvertisingBoardResponseDto.noPerMission();

            // 댓글 데이터 삭제
            shortReviewAdvertisingBoardRepository.deleteByBoardNumber(boardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteShortCommentAdvertisingBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAdvertisingboardResponseDto> getAdvertisingboard(Integer boardNumber) {

        System.out.println(boardNumber);

        AdvertisingViewEntity advertisingViewEntity = null;

        try {
            // 게시물 번호에 해당하는 게시물 조회
            advertisingViewEntity = advertisingBoardViewRespository.findByBoardNumber(boardNumber);
            // 존재하는 게시물인지 확인
            if (advertisingViewEntity == null)
                return GetAdvertisingboardResponseDto.noExistedBoard();
            // 게시물 조회수 증가
            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            advertisingBoardEntity.increaseCommentCount();
            // 데이터 베이스에 저장
            advertisingBoardRepository.save(advertisingBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAdvertisingboardResponseDto.success(advertisingViewEntity);
    }

    // 최근 게시물 불러오기
    @Override
    public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getCurrentAdvertisingBoard(Integer section) {

        List<AdvertisingBoardListResponseDto> advertisingBoardList = new ArrayList<>();

        try {
            // 리스트 불러오기
            Integer limit = (section - 1) * 30;
            List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdvertisingBoardList(limit);

            // 검색결과 responsedto로 변환
            advertisingBoardList = AdvertisingBoardListResponseDto.copyList(resultSets);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCurrentAdvertisingBoardResponseDto.success(advertisingBoardList);

    }

    // 한줄리뷰 리스트 불러오기
    @Override
    public ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(Integer boardNumber) {
        List<ShortReviewResponseDto> shortList = new ArrayList<>();

        try {

            List<ShortReviewResultSet> resultSets = shortReviewAdvertisingBoardRepository.getShortReviewList(boardNumber);

            shortList = ShortReviewResponseDto.copyList(resultSets);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetShortReviewListResponseDto.success(shortList);

    }

    @Override
    public ResponseEntity<? super GetUserListAdvertisingResponseDto> getUserListAdvertising(String writerEmail) {
        List<AdvertisingListResponseDto> advertisingBoardList = new ArrayList<>();


        try{

            List<AdvertisingViewEntity> advertisingBoardEntities = advertisingBoardViewRespository.findByWriterEmailOrderByWriteDatetimeDesc(writerEmail);

            advertisingBoardList = AdvertisingListResponseDto.copyEntityList(advertisingBoardEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
      return GetUserListAdvertisingResponseDto.success(advertisingBoardList);
        }

    @Override

    public ResponseEntity<? super PatchAdvertisingBoardResponseDto> patchAdvertisingBoard(Integer boardNumber,
            String email, PatchAdvertisingRequestDto dto) {
        try {

            // 존재하는 유저인지 확인
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser)
                return PatchAdvertisingBoardResponseDto.noExistedUser();

            // 존재하는 게시물인지 확인
            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingBoardEntity == null)
                return PatchAdvertisingBoardResponseDto.noExistedBoard();

            // 작성자 이메일과 일치하는지 확인
            boolean equalWriter = advertisingBoardEntity.getWriterEmail().equals(email);
            if (!equalWriter)
                return PatchAdvertisingBoardResponseDto.noPermission();

            // 수정
            advertisingBoardEntity.patch(dto);
            // 저장
            advertisingBoardRepository.save(advertisingBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchAdvertisingBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostAdvertisingBoardResponseDto> postAdvertisingBoard(String writerEmail, PostAdvertisingRequestDto dto) {
        try {
            // 존재하는 이메일인지 확인
            boolean hasUser = userRepository.existsByEmail(writerEmail);
            if (!hasUser)
                return PostAdvertisingBoardResponseDto.noExistUser();

            // entity 생성
            AdvertisingBoardEntity advertisingBoardEntity = new AdvertisingBoardEntity(writerEmail, dto);

            // 데이터베이스 저장
            advertisingBoardRepository.save(advertisingBoardEntity);

            List<PostAdvertisingMenuRequestDto> menuList = dto.getMenuList();

            // 글 번호 불러오기
            int boardNumber = advertisingBoardEntity.getBoardNumber();

            // 메뉴 작성한 것 불러오기
            List<AdvertisingMenuEntity> advertisingMenuEntities = new ArrayList<>();
            for (PostAdvertisingMenuRequestDto menuDto: menuList) {
                AdvertisingMenuEntity advertisingMenuEntity = new AdvertisingMenuEntity(boardNumber, menuDto);
                advertisingMenuEntities.add(advertisingMenuEntity);
            }

            // 저장
            advertisingMenuRepository.saveAll(advertisingMenuEntities);

            List<PostTagRequestDto> tagList = dto.getTagWord();

            List<TagEntity> tagEntities = new ArrayList<>();
            for(PostTagRequestDto tagDto: tagList) {
                TagEntity tagEntity = new TagEntity(boardNumber, tagDto);
                tagEntities.add(tagEntity);
            }

            tagRepository.saveAll(tagEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();

        }
        return PostAdvertisingBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostShortReviewResponseDto> postShortReview(Integer boardNumber, String writerEmail,
            PostShortReviewRequestDto dto) {
        try {

            boolean hasUser = userRepository.existsByEmail(writerEmail);
            if (!hasUser)
                return PostShortReviewResponseDto.noExistedUser();

            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingBoardEntity == null)
                return PostShortReviewResponseDto.noExistedBoard();

            AdvertisingShortReviewEntity advertisingShortReviewEntity = new AdvertisingShortReviewEntity(boardNumber,writerEmail,dto);

            shortReviewAdvertisingBoardRepository.save(advertisingShortReviewEntity);

            advertisingBoardEntity.increaseCommentCount();

            advertisingBoardRepository.save(advertisingBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostShortReviewResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PutAdvertisingFavoriteListResponseDto> putAdvertisingFavoriteList(
            Integer boardNumber, String writerEmail) {
        try {

            boolean hasUser = userRepository.existsByEmail(writerEmail);
            if(! hasUser) return PutAdvertisingFavoriteListResponseDto.noExistedUser();

            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if(advertisingBoardEntity == null) return PutAdvertisingFavoriteListResponseDto.noExistedBoard();

            boolean isFavorite = advertisingBoardFavoriteRepository.existsByUserEmailAndBoardNumber(writerEmail,boardNumber);

            AdvertisingBoardFavoriteEntity favoriteEntity = new AdvertisingBoardFavoriteEntity(boardNumber,writerEmail);

            if (isFavorite){
                advertisingBoardFavoriteRepository.delete(favoriteEntity);
                advertisingBoardEntity.decreaseFavoriteCount();
            }

            else{
                advertisingBoardFavoriteRepository.save(favoriteEntity);
                advertisingBoardEntity.increaseFavoriteCount();
            }

            advertisingBoardRepository.save(advertisingBoardEntity);
           

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PutAdvertisingFavoriteListResponseDto.success();
        
    }

    @Override
    public ResponseEntity<? super GetAdvertisingBoardLocationListResponsedto> getAdvertisingBoardLocationList(
            String location) {
        List<AdvertisingBoardListResponseDto> advertisingBoardList = new ArrayList<>();

        try {

            List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByLocationOrderByWriteDatetimeDesc(location);

            advertisingBoardList = AdvertisingBoardListResponseDto.copyEntityList(advertisingViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAdvertisingBoardLocationListResponsedto.success(advertisingBoardList);
    }

    @Override
    public ResponseEntity<? super GetAdvertisingBoardBusinessTypeListResponseDto> getAdvertisingBoardBusinessTypeList(
            String businessType) {

        List<AdvertisingBoardListResponseDto> advertisingBoardList = new ArrayList<>();

        try {
            List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRespository.findByBusinessTypeOrderByWriteDatetimeDesc(businessType);

            advertisingBoardList = AdvertisingBoardListResponseDto.copyEntityList(advertisingViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAdvertisingBoardBusinessTypeListResponseDto.success(advertisingBoardList);

    }

    @Override
    public ResponseEntity<? super PostReservationResponseDto> postReservation(Integer boardNumber, String email,
            String time, int people) {

        try {
            boolean hasUser = userRepository.existsByEmail(email);
            if (!hasUser)
                return PostReservationResponseDto.noExistedUser();

            AdvertisingBoardEntity advertisingBoardEntity = advertisingBoardRepository.findByBoardNumber(boardNumber);
            if (advertisingBoardEntity == null)
                return PostReservationResponseDto.noExistedBoard();

            advertisingBoardRepository.save(advertisingBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostReservationResponseDto.success();

    }

}
