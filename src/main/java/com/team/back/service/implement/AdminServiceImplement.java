package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.admin.UserListResponseDto;
import com.team.back.entity.UserViewEntity;
import com.team.back.entity.resultSet.UserListResultSet;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService {

	private final UserRepository userRepository;
	private final UserViewRepository userViewRepository;

	@Override
	public ResponseEntity<?> getBoardList(String adminId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
	}

	@Override
	public ResponseEntity<?> getShortReviewList(String adminId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShortReviewList'");
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

	@Override
	public ResponseEntity<?> getUserAdvertisingBoardList(String adminId, String userEmail) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserAdvertisingBoardList'");
	}

	@Override
	public ResponseEntity<?> getUserReviewBoardList(String adminId, String userEmail) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserReviewBoardList'");
	}

	@Override
	public ResponseEntity<?> getUserShortReviewList(String adminId, String userEmail) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserShortReviewList'");
	}

	@Override
	public ResponseEntity<?> getUserCommentList(String adminId, String userEmail) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserCommentList'");
	}

	@Override
	public ResponseEntity<?> PatchMainBanner(String adminId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'PatchMainBanner'");
	}
	
}
