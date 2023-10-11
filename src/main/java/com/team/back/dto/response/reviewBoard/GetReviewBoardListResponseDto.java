package com.team.back.dto.response.reviewBoard;

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
public class GetReviewBoardListResponseDto extends ResponseDto {
    
    private List<ReviewBoardListResponseDto> boardList;

    private GetReviewBoardListResponseDto(String code, String message, List<ReviewBoardListResponseDto> boardList) {
        super(code, message);
        this.boardList = boardList;
    }

    public static ResponseEntity<GetReviewBoardListResponseDto> success(List<ReviewBoardListResponseDto> boardList) {
        GetReviewBoardListResponseDto result = new GetReviewBoardListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
