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
public class GetReviewBoardLocationBusinessTypeListResponseDto extends ResponseDto{
    
    private List<ReviewBoardListResponseDto> boardList;

    private GetReviewBoardLocationBusinessTypeListResponseDto (String code, String message, List<ReviewBoardListResponseDto> boardList) {
        super(code, message);
        this.boardList = boardList;
    }

    public static ResponseEntity<GetReviewBoardLocationBusinessTypeListResponseDto> success(List<ReviewBoardListResponseDto> boardList) {
        GetReviewBoardLocationBusinessTypeListResponseDto result = new GetReviewBoardLocationBusinessTypeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
