package com.team.back.dto.response.eventBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.EventBoardViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetEventBoardResponseDto extends ResponseDto {
    private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String WriteDatetime;
	private String adminId;
	private String adminNickname;

	private GetEventBoardResponseDto(String code, String message, EventBoardViewEntity eventBoardViewEntity) {
		super(code, message);
		this.boardNumber = eventBoardViewEntity.getBoardNumber();
		this.title = eventBoardViewEntity.getTitle();
		this.contents = eventBoardViewEntity.getContents();
		this.imageUrl = eventBoardViewEntity.getImageUrl();
		this.WriteDatetime = eventBoardViewEntity.getWriteDatetime();
		this.adminId = eventBoardViewEntity.getWriterEmail();
		this.adminNickname = eventBoardViewEntity.getWriterNickname();
	}

	public static ResponseEntity<GetEventBoardResponseDto> success(EventBoardViewEntity eventBoardViewEntity) {
		GetEventBoardResponseDto result = new GetEventBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, eventBoardViewEntity);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> noExistedBoard() {
		ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
