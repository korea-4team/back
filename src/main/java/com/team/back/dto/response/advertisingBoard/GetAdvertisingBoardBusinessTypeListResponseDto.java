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
public class GetAdvertisingBoardBusinessTypeListResponseDto extends ResponseDto{
  private List<AdvertisingBoardListResponseDto> advertisingboardList;

  private GetAdvertisingBoardBusinessTypeListResponseDto(String code, String message, List<AdvertisingBoardListResponseDto> advertisingboardList){
    super(code, message);
    this.advertisingboardList = advertisingboardList;
    
  }

  public static ResponseEntity<GetAdvertisingBoardBusinessTypeListResponseDto> success(List<AdvertisingBoardListResponseDto> advertisingboardList){
    GetAdvertisingBoardBusinessTypeListResponseDto result = new GetAdvertisingBoardBusinessTypeListResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,advertisingboardList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
}
