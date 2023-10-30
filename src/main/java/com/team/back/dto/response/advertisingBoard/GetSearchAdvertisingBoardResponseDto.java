package com.team.back.dto.response.advertisingBoard;

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
public class GetSearchAdvertisingBoardResponseDto extends ResponseDto{

  private List<AdvertisingBoardListResponseDto> advertisingBoardList;
  
  private GetSearchAdvertisingBoardResponseDto(String code,String message, List<AdvertisingBoardListResponseDto> advertisingBoardList) {
    super(code,message);
    this.advertisingBoardList = advertisingBoardList;
  }

  public static ResponseEntity<GetSearchAdvertisingBoardResponseDto> success(List<AdvertisingBoardListResponseDto> advertisingBoardList){
    GetSearchAdvertisingBoardResponseDto rersult = new GetSearchAdvertisingBoardResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,advertisingBoardList);
    return ResponseEntity.status(HttpStatus.OK).body(rersult);
  }
  
}
