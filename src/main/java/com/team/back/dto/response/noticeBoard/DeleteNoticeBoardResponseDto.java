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
public class DeleteNoticeBoardResponseDto extends ResponseDto {
	private DeleteNoticeBoardResponseDto(String code, String message) {
		super(code, message);
	}

	public ResponseEntity<DeleteNoticeBoardResponseDto> success() {
		DeleteNoticeBoardResponseDto result = new DeleteNoticeBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public ResponseEntity<DeleteNoticeBoardResponseDto> notAdminId() {
		DeleteNoticeBoardResponseDto result = new DeleteNoticeBoardResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	public ResponseEntity<DeleteNoticeBoardResponseDto> notExistedBoard() {
		DeleteNoticeBoardResponseDto result = new DeleteNoticeBoardResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
