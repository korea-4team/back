package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.noticeBoard.PatchNoticeBoardRequestDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.noticeBoard.DeleteNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.GetNoticeBoardListResponseDto;
import com.team.back.dto.response.noticeBoard.GetNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.NoticeBoardListResponseDto;
import com.team.back.dto.response.noticeBoard.PatchNoticeBoardResponseDto;
import com.team.back.dto.response.noticeBoard.PostNoticeBoardResponseDto;
import com.team.back.entity.NoticeBoardEntity;
import com.team.back.entity.NoticeBoardViewEntity;
import com.team.back.entity.resultSet.NoticeBoardListResultSet;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.NoticeBoardRepository;
import com.team.back.repository.NoticeBoardViewRepository;
import com.team.back.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImplement implements NoticeBoardService {
	
	private AdminRepository adminRepository;
	private NoticeBoardRepository noticeBoardRepository;
	private NoticeBoardViewRepository noticeBoardViewRepository;

	@Override
	// description : 공지사항 게시물 리스트 불러오기 메서드
	public ResponseEntity<? super GetNoticeBoardListResponseDto> getNoticeBoardList() {
		
		List<NoticeBoardListResponseDto> noticeBoardList = null;

		try {
			// 게시물 리스트 불러오기
			List<NoticeBoardListResultSet> resultSets = noticeBoardRepository.getNoticeBoardList();

			// 검색 결과를 ResponseDto 형태로 변환
			noticeBoardList = NoticeBoardListResponseDto.copyList(resultSets);
		
		} catch (Exception exception) {
			exception.printStackTrace();
			return GetNoticeBoardListResponseDto.databaseError();
		}

		return GetNoticeBoardListResponseDto.success(noticeBoardList);
	}

	@Override
	// description : 공지사항 게시물 상세보기 메서드
	public ResponseEntity<? super GetNoticeBoardResponseDto> getNoticeBoard(Integer boardNumber) {
		
		NoticeBoardViewEntity noticeBoardViewEntity = null;

		try {

			// 게시물 번호에 해당하는 게시물 조회
			noticeBoardViewEntity = noticeBoardViewRepository.findByBoardNumber(boardNumber);

			// 존재하는 게시물인지 확인
			if (noticeBoardViewEntity == null) return GetNoticeBoardResponseDto.noExistedBoard();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return GetNoticeBoardResponseDto.success(noticeBoardViewEntity);

	}

	@Override
	// description : 공지사항 게시물 작성 메서드
	public ResponseEntity<? super PostNoticeBoardResponseDto> postNoticeBoard(String adminId, PostNoticeBoardRequestDto dto) {

		try {
			// admin 계정이 존재하는지 확인
			boolean hasAdmin = adminRepository.existsByAdminId(adminId);
			if (!hasAdmin) return PostNoticeBoardResponseDto.NotAdminId();

			// entity 생성
			NoticeBoardEntity noticeBoardEntity = new NoticeBoardEntity(adminId, dto);

			// 데이터베이스에 저장
			noticeBoardRepository.save(noticeBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		
		return PostNoticeBoardResponseDto.success();

	}

	@Override
	// description : 공지사항 수정 메서드
	public ResponseEntity<? super PatchNoticeBoardResponseDto> patchNoticeBoard(Integer boardNumber, String adminId,
			PatchNoticeBoardRequestDto dto) {
			
			try {
				
				// admin 아이디인지 확인
				boolean isAdmin = adminRepository.existsByAdminId(adminId);
				if(!isAdmin) return PatchNoticeBoardResponseDto.notAdminId();

				// 존재하는 게시물인지 확인
				NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByBoardNumber(boardNumber);
				if (noticeBoardEntity == null) return PatchNoticeBoardResponseDto.noExistedBoard();

				// 수정
				noticeBoardEntity.patch(dto);

				// 데이터 베이스에 저장
				noticeBoardRepository.save(noticeBoardEntity);

			} catch (Exception exception) {
				exception.printStackTrace();
				return ResponseDto.databaseError();
			}

			return PatchNoticeBoardResponseDto.success();
		}

	@Override
	// description : 공지사항 삭제 메서드
	public ResponseEntity<? super DeleteNoticeBoardResponseDto> deleteNoticeBoard(Integer boardNumber, String adminId) {
	
		try {
			// admin 아이디인지 확인
			boolean isAdmin = adminRepository.existsByAdminId(adminId);
			if (!isAdmin) return DeleteNoticeBoardResponseDto.notAdminId();

			// 존재하는 게시물인지 확인
			NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByBoardNumber(boardNumber);
			if (noticeBoardEntity == null) return DeleteNoticeBoardResponseDto.noExistedBoard();

			// 게시물 삭제
			noticeBoardRepository.delete(noticeBoardEntity);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return DeleteNoticeBoardResponseDto.databaseError();
		}

		return DeleteNoticeBoardResponseDto.success();
		
	}

}
