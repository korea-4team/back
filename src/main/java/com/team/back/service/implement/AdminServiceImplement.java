package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.noticeBoard.PatchNoticeBoardRequestDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.admin.AdvertisingListResponseDto;
import com.team.back.dto.response.admin.GetAdvertisingBoardListResponseDto;
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.admin.UserListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.ShortReviewResponseDto;
import com.team.back.dto.response.reviewBoard.CommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.entity.AdvertisingShortReviewEntity;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.CommentViewEntity;
import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.UserViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
import com.team.back.entity.resultSet.ShortReviewResultSet;
import com.team.back.entity.resultSet.UserListResultSet;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.AdvertisingBoardViewRespository;
import com.team.back.repository.CommentViewRepository;
import com.team.back.repository.ReviewBoardRepository;
import com.team.back.repository.ReviewBoardViewRepository;
import com.team.back.repository.ShortReviewAdvertisingBoardRepository;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService {

	private final UserRepository userRepository;
	private final UserViewRepository userViewRepository;
	private final ReviewBoardRepository reviewBoardRepository;
	private final ReviewBoardViewRepository reviewBoardViewRepository;
	private final AdvertisingBoardRepository advertisingBoardRepository;
	private final AdvertisingBoardViewRespository advertisingBoardViewRepository;
	private final ShortReviewAdvertisingBoardRepository shortReviewAdvertisingBoardRepository;
	private final CommentViewRepository commentViewRepository;

	// description : 전체 광고 게시글 리스트 불러오기
	@Override
	public ResponseEntity<? super GetAdvertisingBoardListResponseDto> getAdvertisingBoardList(String adminId) {
		
		List<AdvertisingListResponseDto> advertisingBoardList = null;

		try {
			
			// 광고 게시글 리스트 불러오기
			List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdvertisingBoardList();
			// Dto 형태로 변환
			advertisingBoardList = AdvertisingListResponseDto.copyList(resultSets);
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetAdvertisingBoardListResponseDto.databaseError();
		}

		return GetAdvertisingBoardListResponseDto.success(advertisingBoardList);
	}

	// description : 전체 기행기 게시글 리스트 불러오기
	@Override
	public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList(String adminId) {
	
		List<ReviewBoardListResponseDto> reviewBoardList = null;

		try {
			// 기행기 게시글 리스트 불러오기
			List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getReviewBoardList();
			// 검색 결과를 Dto 형태로 변환
			reviewBoardList = ReviewBoardListResponseDto.copyList(resultSets);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetReviewBoardListResponseDto.databaseError();
		}

		return GetReviewBoardListResponseDto.success(reviewBoardList);
	}


	// description : 전체 한 줄 리뷰 리스트 불러오기
	@Override
	public ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(String adminId) {
		
		List<ShortReviewResponseDto> shortReviewList = null;

		try {
			// 댓글 리스트 불러오기
			List<ShortReviewResultSet> resultSets = shortReviewAdvertisingBoardRepository.getShortReviewList();

			// 검색 결과를 Dto 형태로 변환
			shortReviewList = ShortReviewResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetShortReviewListResponseDto.databaseError();
		}

		return GetShortReviewListResponseDto.success(shortReviewList);

	}

	// description : 유저 리스트 불러오기
	@Override
	public ResponseEntity<? super GetUserListResponseDto> getUserList(String adminId) {

		List<UserListResponseDto> userList = null;

		try {
			
			// 유저 리스트 불러오기
			List<UserListResultSet> resultSets = userRepository.getUserList();

			// 검색 결과를 ResponseDto 형태로 변환
			userList = UserListResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetUserListResponseDto.databaseError();
		}

		return GetUserListResponseDto.success(userList);
	}

	// description : 유저 정보 상세보기
	@Override
	public ResponseEntity<? super GetUserDetailResponseDto> getUserDetail(String adminId, String userEmail) {
		
		UserViewEntity userViewEntity = null;

		try {
			
			// 유저 이메일에 해당하는 유저 정보 조회
			userViewEntity = userViewRepository.findByUserEmail(userEmail);

			// 존재하는 유저인지 확인
			if (userViewEntity == null) return GetUserDetailResponseDto.noExistedUser();

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetUserDetailResponseDto.databaseError();
		}

		return GetUserDetailResponseDto.success(userViewEntity);
	}

	// 해당 유저 작성 광고 게시글
	@Override
	public ResponseEntity<? super GetAdvertisingBoardListResponseDto> getUserAdvertisingBoardList(String adminId, String userEmail) {
		
		List<AdvertisingListResponseDto> advertisingBoardList = null;

		try {

			// 특정 이메일에 해당하는 광고 게시글 조회
			List<AdvertisingViewEntity> advertisingViewEntities = advertisingBoardViewRepository.findByWriterEmail(userEmail);
			
			// 검색 결과를 Dto 형태로 반환
			advertisingBoardList = AdvertisingListResponseDto.copyEntityList(advertisingViewEntities);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetAdvertisingBoardListResponseDto.databaseError();
		}

		return GetAdvertisingBoardListResponseDto.success(advertisingBoardList);

	}

	// description : 해당 유저 작성 기행기 게시글 리스트
	@Override
	public ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail) {
		
		List<ReviewBoardListResponseDto> reviewBoardList = null;

		try {

			// 특정 이메일에 해당하는 기행기 리스트 조회
			List<ReviewBoardViewEntity> reviewBoardViewEntities = reviewBoardViewRepository.findByWriterEmail(userEmail);

			// 검색 결과를 Dto 형태로 변환
			reviewBoardList = ReviewBoardListResponseDto.copyEntityList(reviewBoardViewEntities);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetReviewBoardListResponseDto.databaseError();
		}

		return GetReviewBoardListResponseDto.success(reviewBoardList);
	}

	// description : 해당 유저 한 줄 리뷰 리스트
	@Override
	public ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail) {
	
		List<ShortReviewResponseDto> shortReviewList = null;

		try {
			
			// 특정 이메일에 해당하는 한 줄 리뷰 리스트 조회
			List<AdvertisingShortReviewEntity> shortReviewEntities = shortReviewAdvertisingBoardRepository.findByUserEmail(userEmail);

			// 검색 결과를 Dto 형태로 반환
			shortReviewList = ShortReviewResponseDto.copyEntityList(shortReviewEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetShortReviewListResponseDto.databaseError();
		}

		return GetShortReviewListResponseDto.success(shortReviewList);

	}

	// description : 해당 유저 댓글 리스트
	@Override
	public ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail) {
		List<CommentListResponseDto> commentList = null;

		try {
			
			// 특정 이메일에 해당하는 댓글 리스트 조회
			List<CommentViewEntity> commentViewEntities = commentViewRepository.findByUserEmail(userEmail);

			// 검색 결과를 Dto 형태로 반환
			commentList = CommentListResponseDto.copyEntityList(commentViewEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetCommentListResponseDto.databaseError();
		}

		return GetCommentListResponseDto.success(commentList);
	}

	@Override
	public ResponseEntity<?> postNoticeBoard(String adminId, PostNoticeBoardRequestDto dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'postNoticeBoard'");
	}

	@Override
	public ResponseEntity<?> patchNoticeBoard(Integer boardNumber, String adminId, PatchNoticeBoardRequestDto dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'patchNoticeBoard'");
	}

	@Override
	public ResponseEntity<?> deleteNoticeBoard(Integer boardNumber, String adminId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteNoticeBoard'");
	}


	
}
