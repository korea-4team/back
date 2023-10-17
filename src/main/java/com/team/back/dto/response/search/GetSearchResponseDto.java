package com.team.back.dto.response.search;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.advertisingBoard.AdvertisingBoardListResponseDto;
import com.team.back.dto.response.reviewBoard.ReviewBoardListResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetSearchResponseDto extends ResponseDto {
    
    private List<ReviewBoardListResponseDto> reviewBoardList;
    private List<AdvertisingBoardListResponseDto> advertisingBoardList;

    private GetSearchResponseDto(String code, String message, List<ReviewBoardListResponseDto> reviewBoardList, List<AdvertisingBoardListResponseDto> advertisingBoardList) {
        super(code, message);
        this.reviewBoardList = reviewBoardList;
        this.advertisingBoardList = advertisingBoardList;
    }

    public static ResponseEntity<GetSearchResponseDto> success(List<ReviewBoardListResponseDto> reviewBoardList, List<AdvertisingBoardListResponseDto> advertisingBoardList) {
        GetSearchResponseDto result = new GetSearchResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, reviewBoardList, advertisingBoardList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
