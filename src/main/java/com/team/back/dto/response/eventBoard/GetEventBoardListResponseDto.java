package com.team.back.dto.response.eventBoard;

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
public class GetEventBoardListResponseDto extends ResponseDto {
    
    private List<EventBoardListResponseDto> eventBoardList;

    private GetEventBoardListResponseDto(String code, String message, List<EventBoardListResponseDto> eventBoardList) {
        super(code, message);
        this.eventBoardList = eventBoardList;
    }

    public static ResponseEntity<GetEventBoardListResponseDto> success(List<EventBoardListResponseDto> eventBoardList) {
        GetEventBoardListResponseDto result = new GetEventBoardListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, eventBoardList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
