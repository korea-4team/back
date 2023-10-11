package com.team.back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.myPage.PatchUserRequestDto;
import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.GetBoardListResponseDto;
import com.team.back.dto.response.myPage.GetMyCommentListResponseDto;
import com.team.back.dto.response.myPage.GetMyReservationListResponseDto;
import com.team.back.dto.response.myPage.GetMyShortReviewListResponseDto;
import com.team.back.dto.response.myPage.GetMyStoreReservationListResponseDto;
import com.team.back.dto.response.myPage.GetStoreInfoResponseDto;
import com.team.back.dto.response.myPage.PatchUserResponseDto;
import com.team.back.dto.response.myPage.PostRegistrationResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.entity.BusinessApplicationEntity;
import com.team.back.entity.BusinessNumberEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.UserEntity;
import com.team.back.entity.resultSet.UserCommentListResultSet;
import com.team.back.entity.resultSet.UserReservationListResultSet;
import com.team.back.entity.resultSet.UserShortReviewListResultSet;
import com.team.back.entity.resultSet.UserStoreReservationListResultSet;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.BusinessApplicationRepository;
import com.team.back.repository.BusinessNumberRepository;
import com.team.back.repository.CommentRepository;
import com.team.back.repository.ReservationRepository;
import com.team.back.repository.ReviewBoardViewRepository;
import com.team.back.repository.ShortReviewAdvertisingBoardRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService {
    
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ReservationRepository reservationRepository;
    private final BusinessNumberRepository businessNumberRepository;
    private final ReviewBoardViewRepository reviewBoardViewRepository;
    private final AdvertisingBoardRepository advertisingBoardRepository;
    private final BusinessApplicationRepository businessApplicationRepository;
    private final ShortReviewAdvertisingBoardRepository shortReviewAdvertisingBoardRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super PostRegistrationResponseDto> registration(RegistrationRequestDto dto, String email) {

        String storeNumber = dto.getStoreNumber();

        try {

            boolean existedStoreNumber = businessNumberRepository.existsByStoreNumber(storeNumber);
            if (existedStoreNumber) return PostRegistrationResponseDto.existStoreNumber();

            BusinessApplicationEntity businessApplicationEntity = new BusinessApplicationEntity(dto, email);
            businessApplicationRepository.save(businessApplicationEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostRegistrationResponseDto.success();

    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList(String email) {

        List<ReviewBoardListResponseDto> boardList = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetBoardListResponseDto.notExistUser();

            List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByWriterEmail(email);
            boardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBoardListResponseDto.success(boardList);

    }

    @Override
    public ResponseEntity<? super GetStoreInfoResponseDto> getStoreInfo(String email) {
       
        BusinessNumberEntity businessNumberEntity = null;

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetStoreInfoResponseDto.notExistUser();

            businessNumberEntity = businessNumberRepository.findByUserEmail(email);
            if (businessNumberEntity == null) return GetStoreInfoResponseDto.notExistStore();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStoreInfoResponseDto.success(businessNumberEntity);

    }

    @Override
    public ResponseEntity<? super GetMyCommentListResponseDto> getMyCommentList(String email) {

        List<UserCommentListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetMyCommentListResponseDto.notExistUser();

            resultSets = commentRepository.getMyCommentList(email);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMyCommentListResponseDto.success(resultSets);

    }
    
    @Override
    public ResponseEntity<? super GetMyReservationListResponseDto> getMyReservationList(String email) {
        
        List<UserReservationListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetMyCommentListResponseDto.notExistUser();

            resultSets = reservationRepository.getUserReservationList(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMyReservationListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super GetMyShortReviewListResponseDto> getMyShortReviewList(String email) {
        
        List<UserShortReviewListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetMyCommentListResponseDto.notExistUser();

            resultSets = shortReviewAdvertisingBoardRepository.getUserShortReviewList(email);

        } catch(Exception exceptiopn) {
             exceptiopn.printStackTrace();
             return ResponseDto.databaseError();
        }

        return GetMyShortReviewListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super GetMyStoreReservationListResponseDto> getMyStoreReservationList(String email) {
        
        List<UserStoreReservationListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetMyStoreReservationListResponseDto.notExistUser();

            boolean existedBoard = advertisingBoardRepository.existsByWriterEmail(email);
            if (!existedBoard) return GetMyStoreReservationListResponseDto.notExistUser();

            resultSets = reservationRepository.getUserStoreReservationList(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMyStoreReservationListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super PatchUserResponseDto> patchUser(PatchUserRequestDto dto, String email) {

        String telNumber = dto.getTelNumber();
        String nickname = dto.getNickname();
        
        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return PatchUserResponseDto.notExistUser();

            String myTelNumber = userEntity.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (!myTelNumber.equals(telNumber) && existedTelNumber) return PatchUserResponseDto.existTelNumber();

            String myNickname = userEntity.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if (!myNickname.equals(nickname) && existedNickname) return PatchUserResponseDto.existNickname();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            userEntity.patchUser(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchUserResponseDto.success();

    }

}
