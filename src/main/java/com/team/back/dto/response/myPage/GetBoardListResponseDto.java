package com.team.back.dto.response.myPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;

import lombok.Getter;

@Getter
public class GetBoardListResponseDto extends ResponseDto {
     private List<ReviewBoardListResponseDto> boardList;

    private GetBoardListResponseDto(List<ReviewBoardListResponseDto> boardList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.boardList = boardList;
    }

    public static ResponseEntity<GetBoardListResponseDto> success(List<ReviewBoardListResponseDto> boardList) {
        GetBoardListResponseDto result = new GetBoardListResponseDto(boardList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
