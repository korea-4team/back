package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;
import com.team.back.dto.response.noticeBoard.PostNoticeBoardResponseDto;
import com.team.back.entity.NoticeBoardEntity;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.NoticeBoardRepository;
import com.team.back.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImplement implements NoticeBoardService {
	
	private AdminRepository adminRepository;
	private NoticeBoardRepository noticeBoardRepository;

	@Override
	// description : 공지사항 게시물 작성 메서드
	public ResponseEntity<? super PostNoticeBoardResponseDto> postBoard(String adminId, PostNoticeBoardRequestDto dto) {

		try {
			// description : admin 계정이 존재하는지 확인
			boolean hasAdmin = adminRepository.existsByAdminId(adminId);
			if (!hasAdmin) return PostNoticeBoardResponseDto.NotAdminId();

			// description : entity 생성
			NoticeBoardEntity noticeBoardEntity = new NoticeBoardEntity(adminId, dto);

			// description : 데이터베이스에 저장
			noticeBoardRepository.save(noticeBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		
		return PostNoticeBoardResponseDto.success();

		



	}
	
}
