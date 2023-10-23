package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.banner.PatchBannerRequestDto;
import com.team.back.dto.request.banner.PostBannerRequestDto;
import com.team.back.dto.response.admin.GetUserDetailResponseDto;
import com.team.back.dto.response.admin.GetUserListResponseDto;
import com.team.back.dto.response.admin.UserListResponseDto;
import com.team.back.dto.response.advertisingBoard.AdvertisingBoardListResponseDto;
import com.team.back.dto.response.advertisingBoard.GetCurrentAdvertisingBoardResponseDto;
import com.team.back.dto.response.advertisingBoard.GetShortReviewListResponseDto;
import com.team.back.dto.response.advertisingBoard.ShortReviewResponseDto;
import com.team.back.dto.response.banner.DeleteBannerResponseDto;
import com.team.back.dto.response.banner.GetMainBannerDetailResponseDto;
import com.team.back.dto.response.banner.GetMainBannerListResponseDto;
import com.team.back.dto.response.banner.MainBannerListResponseDto;
import com.team.back.dto.response.banner.PatchMainBannerResponseDto;
import com.team.back.dto.response.banner.PostMainBannerResponseDto;
import com.team.back.dto.response.myPage.GetStoreInfoResponseDto;
import com.team.back.dto.response.reviewBoard.CommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetCommentListResponseDto;
import com.team.back.dto.response.reviewBoard.GetReviewBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;
import com.team.back.entity.BannerEntity;
import com.team.back.entity.BusinessNumberEntity;
import com.team.back.entity.UserEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;
import com.team.back.entity.resultSet.CommentListResultSet;
import com.team.back.entity.resultSet.MainBannerListResultSet;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;
import com.team.back.entity.resultSet.ShortReviewResultSet;
import com.team.back.entity.resultSet.UserListResultSet;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.AdvertisingBoardRepository;
import com.team.back.repository.BannerRepository;
import com.team.back.repository.BusinessNumberRepository;
import com.team.back.repository.CommentRepository;
import com.team.back.repository.EventBoardRepository;
import com.team.back.repository.ReviewBoardRepository;
import com.team.back.repository.ShortReviewAdvertisingBoardRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImplement implements AdminService {

	private final UserRepository userRepository;
	private final ReviewBoardRepository reviewBoardRepository;
	private final AdvertisingBoardRepository advertisingBoardRepository;
	private final ShortReviewAdvertisingBoardRepository shortReviewAdvertisingBoardRepository;
	private final CommentRepository commentRepository;
	private final AdminRepository adminRepository;
	private final BannerRepository bannerRepository;
	private final BusinessNumberRepository businessNumberRepository;
	private final EventBoardRepository eventBoardRepository;

	// description : 전체 광고 게시글 리스트 불러오기
	@Override
	public ResponseEntity<? super GetCurrentAdvertisingBoardResponseDto> getAdvertisingBoardList(String adminId, Integer section) {
		
		List<AdvertisingBoardListResponseDto> advertisingBoardList = null;

		try {
			
			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetCurrentAdvertisingBoardResponseDto.notAdminId();

			// 광고 게시글 리스트 불러오기
			Integer limit = (section -1) * 30;
			List<AdvertisingBoardResultSet> resultSets = advertisingBoardRepository.getAdminAdvertisingBoardList(limit);
			
			// Dto 형태로 변환
			advertisingBoardList = AdvertisingBoardListResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetCurrentAdvertisingBoardResponseDto.databaseError();
		}

		return GetCurrentAdvertisingBoardResponseDto.success(advertisingBoardList);
	}

	// description : 전체 기행기 게시글 리스트 불러오기
	@Override
	public ResponseEntity<? super GetReviewBoardListResponseDto> getReviewBoardList(String adminId, Integer section) {
	
		List<ReviewBoardListResponseDto> reviewBoardList = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetReviewBoardListResponseDto.notAdminId();

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
	public ResponseEntity<? super GetShortReviewListResponseDto> getShortReviewList(String adminId, Integer section) {
		
		List<ShortReviewResponseDto> shortReviewList = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetShortReviewListResponseDto.notAdminId();

			// 댓글 리스트 불러오기
			Integer limit = (section -1) * 30;
			List<ShortReviewResultSet> resultSets = shortReviewAdvertisingBoardRepository.getAdminShortReviewList(limit);

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
	public ResponseEntity<? super GetUserListResponseDto> getUserList(String adminId, Integer section) {

		List<UserListResponseDto> userList = null;

		try {
			
			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetUserListResponseDto.notAdminId();

			// 유저 리스트 불러오기
			Integer limit = (section -1) * 30;
			List<UserListResultSet> resultSets = userRepository.getUserList(limit);

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
		
		UserEntity userEntity = null;

		try {
			
			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetUserDetailResponseDto.notAdminId();

			// 유저 이메일에 해당하는 유저 정보 조회
			userEntity = userRepository.findByEmail(userEmail);

			// 존재하는 유저인지 확인
			if (userEntity == null) return GetUserDetailResponseDto.noExistedUser();

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetUserDetailResponseDto.databaseError();
		}

		return GetUserDetailResponseDto.success(userEntity);
	}

	// description : 해당 유저 작성 사업자 등록 정보
	@Override
	public ResponseEntity<? super GetStoreInfoResponseDto> getUserStoreInfo(String adminId, String userEmail) {
		
		BusinessNumberEntity businessNumberEntity = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetStoreInfoResponseDto.notAdminId();

			// 존재하는 유저인지 확인
			boolean existedUser = userRepository.existsByEmail(userEmail);
			if (!existedUser) return GetStoreInfoResponseDto.notExistUser();

			//  가게 정보가 존재하는지 확인
			businessNumberEntity = businessNumberRepository.findByUserEmail(userEmail);
			if (businessNumberEntity == null) return GetStoreInfoResponseDto.notExistStore();

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return GetStoreInfoResponseDto.success(businessNumberEntity);
	}

	// description : 해당 유저 작성 기행기 게시글 리스트
	@Override
	public ResponseEntity<? super GetReviewBoardListResponseDto> getUserReviewBoardList(String adminId, String userEmail, Integer section) {
		
		List<ReviewBoardListResponseDto> reviewBoardList = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetReviewBoardListResponseDto.notAdminId();

			 // 해당 유저가 작성한 최신 기행기 게시물 리스트 불러오기
			List<ReviewBoardListResultSet> resultSets = reviewBoardRepository.getUserReviewBoardList(userEmail);

			// 검색 결과를 Dto 형태로 변환
			reviewBoardList = ReviewBoardListResponseDto.copyList(resultSets);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetReviewBoardListResponseDto.databaseError();
		}

		return GetReviewBoardListResponseDto.success(reviewBoardList);
	}

	// description : 해당 유저 한 줄 리뷰 리스트
	@Override
	public ResponseEntity<? super GetShortReviewListResponseDto> getUserShortReviewList(String adminId, String userEmail, Integer section) {
	
		List<ShortReviewResponseDto> shortReviewList = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetShortReviewListResponseDto.notAdminId();

			// 해당 유저가 작성한 한 줄 리뷰 리스트 조회
			Integer limit = (section - 1) * 30;
			List<ShortReviewResultSet> resultSets = shortReviewAdvertisingBoardRepository.getUserShortReviewList(userEmail, limit);

			// 검색 결과를 Dto 형태로 반환
			shortReviewList = ShortReviewResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetShortReviewListResponseDto.databaseError();
		}

		return GetShortReviewListResponseDto.success(shortReviewList);

	}

	// description : 해당 유저 댓글 리스트
	@Override
	public ResponseEntity<? super GetCommentListResponseDto> getUserCommentList(String adminId, String userEmail, Integer section) {
		
		List<CommentListResponseDto> commentList = null;

		try {

			// admin 아이디가 일치하는지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return GetCommentListResponseDto.notAdminId();
			
			// 해당 유저가 작성한 댓글 리스트 조회
			Integer limit = (section - 1) * 30;
			List<CommentListResultSet> resultSets = commentRepository.getUserCommentList(userEmail, limit);

			// 검색 결과를 Dto 형태로 반환
			commentList = CommentListResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetCommentListResponseDto.databaseError();
		}

		return GetCommentListResponseDto.success(commentList);
	}

	// description : 메인 베너 리스트 불러오기
	@Override
	public ResponseEntity<? super GetMainBannerListResponseDto> getMainBannerList(String adminId) {
		
		List<MainBannerListResponseDto> mainBannerList = null;

		try {

			// 베너 리스트 불러오기
			List<MainBannerListResultSet> resultSets = bannerRepository.getMainBannerList();
			
			// 검색 결과를 ResponseDto 형태로 변환
			mainBannerList = MainBannerListResponseDto.copyList(resultSets);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return GetMainBannerListResponseDto.success(mainBannerList);

	}

	// description : 메인 베너 상세보기
	@Override
	public ResponseEntity<? super GetMainBannerDetailResponseDto> getMainBannerDetail(String adminId, int bannerNumber) {
		
		BannerEntity bannerEntity = null;

		try {
			
			// admin 아이디인지 확인
			boolean hasAdmin = adminRepository.existsByAdminId(adminId);
			if(!hasAdmin) return GetMainBannerDetailResponseDto.notAdminId();

			// 존재하는 베너인지 확인
			bannerEntity = bannerRepository.findByBannerNumber(bannerNumber);
			if (bannerEntity == null) return GetMainBannerDetailResponseDto.noExistedBoard();
			

		} catch (Exception exception) {
			exception.printStackTrace();
			return GetUserDetailResponseDto.databaseError();
		}

		return GetMainBannerDetailResponseDto.success(bannerEntity);
	}

	// description : 베너 작성
	@Override
	public ResponseEntity<? super PostMainBannerResponseDto> postBanner(String adminId, int eventBoardNumber, PostBannerRequestDto dto) {
		
		try {
		
			// adminId 인지 확인
			boolean hasAdmin = adminRepository.existsByAdminId(adminId);
			if(!hasAdmin) return PostMainBannerResponseDto.notAdminId();

			// 존재하는 eventBoardNumber 인지 확인
			boolean hasEventBoard = eventBoardRepository.existsByBoardNumber(eventBoardNumber);
			if(!hasEventBoard) return PostMainBannerResponseDto.noExistedBoard();

			// entity 생성
			BannerEntity bannerEntity = new BannerEntity(adminId, eventBoardNumber, dto);

			// 데이터에베이스에 저장
			bannerRepository.save(bannerEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return PostMainBannerResponseDto.success();
	}

	// description : 베너 수정
	@Override
	public ResponseEntity<? super PatchMainBannerResponseDto> patchBanner(Integer bannerNumber, String adminId,
			PatchBannerRequestDto dto) {
		try {

			// admin 아이디인지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if(!isAdmin) return PatchMainBannerResponseDto.notAdminId();

			// 존재하는 banner인지 확인
			BannerEntity bannerEntity = bannerRepository.findByBannerNumber(bannerNumber);
			if (bannerEntity == null) return PatchMainBannerResponseDto.noExistedBoard();

			// 수정
			bannerEntity.patch(dto);

			// 데이터 베이스에 저장
			bannerRepository.save(bannerEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return PatchMainBannerResponseDto.success();
	}

	// description : 베너 삭제
	@Override
	public ResponseEntity<? super DeleteBannerResponseDto> deleteBanner(Integer bannerNumber, String adminId) {
		try {
			
			// admin 아이디인지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if (!isAdmin) return DeleteBannerResponseDto.notAdminId();

			// 존재하는 게시물인지 확인
			BannerEntity bannerEntity = bannerRepository.findByBannerNumber(bannerNumber);
			if (bannerEntity == null) return DeleteBannerResponseDto.noExistedBoard();

			// 게시물 삭제
			bannerRepository.delete(bannerEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return DeleteBannerResponseDto.success();
	}
	
}
