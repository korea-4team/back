package com.team.back.dto.response.noticeBoard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetNoticeBoardListResponseDto extends ResponseDto {
	
	private List<NoticeBoardListResponseDto> noticeBoardList;

	private GetNoticeBoardListResponseDto(String code, String message, List<NoticeBoardListResponseDto> noticeBoardList) {
		super(code, message);
		this.noticeBoardList = noticeBoardList;
	}

	public static ResponseEntity<? super GetNoticeBoardListResponseDto> success(List<NoticeBoardListResponseDto> noticeBoardList) {
		GetNoticeBoardListResponseDto result = new GetNoticeBoardListResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS, noticeBoardList);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
