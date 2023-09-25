package com.team.back.dto.response.noticeBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchNoticeBoardResponseDto extends ResponseDto {
	
	private PatchNoticeBoardResponseDto (String code, String message) {
		super(code, message);
	}

	public static ResponseEntity<PatchNoticeBoardResponseDto> success() {
		PatchNoticeBoardResponseDto result = new PatchNoticeBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<PatchNoticeBoardResponseDto> NotAdminId() {
		PatchNoticeBoardResponseDto result = new PatchNoticeBoardResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	public static ResponseEntity<ResponseDto> noExistedBoard() {
		PatchNoticeBoardResponseDto result = new PatchNoticeBoardResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
