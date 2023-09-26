package com.team.back.dto.response.noticeBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.NoticeBoardViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class GetNoticeBoardResponseDto extends ResponseDto {
	private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String WriteDatetime;
	private String adminId;
	private String adminNickname;

	private GetNoticeBoardResponseDto(String code, String message, NoticeBoardViewEntity noticeBoardViewEntity) {
		super(code, message);
		this.boardNumber = noticeBoardViewEntity.getBoardNumber();
		this.title = noticeBoardViewEntity.getTitle();
		this.contents = noticeBoardViewEntity.getContents();
		this.imageUrl = noticeBoardViewEntity.getImageUrl();
		this.WriteDatetime = noticeBoardViewEntity.getWriteDatetime();
		this.adminId = noticeBoardViewEntity.getWriterEmail();
		this.adminNickname = noticeBoardViewEntity.getWriterNickname();
	}

	public static ResponseEntity<GetNoticeBoardResponseDto> success(NoticeBoardViewEntity noticeBoardViewEntity) {
		GetNoticeBoardResponseDto result = new GetNoticeBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, noticeBoardViewEntity);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> noExistedBoard() {
		ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
