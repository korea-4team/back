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
public class PostNoticeBoardResponseDto extends ResponseDto {
	
	private PostNoticeBoardResponseDto (String code, String message) {
		super(code, message);
	}

	public static ResponseEntity<PostNoticeBoardResponseDto> success() {
		PostNoticeBoardResponseDto result = new PostNoticeBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> NotAdminId() {
		PostNoticeBoardResponseDto result = new PostNoticeBoardResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
