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
public class GetCommentListResponseDto extends ResponseDto {
    
    private List<CommentListResponseDto> commentList;

    private GetCommentListResponseDto(String code, String message, List<CommentListResponseDto> commentList) {
        super(code, message);
        this.commentList = commentList;
    }

    public static ResponseEntity<GetCommentListResponseDto> success(List<CommentListResponseDto> commentList) {
        GetCommentListResponseDto result = new GetCommentListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, commentList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
