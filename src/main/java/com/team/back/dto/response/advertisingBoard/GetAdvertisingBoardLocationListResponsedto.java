package com.team.back.dto.response.advertisingBoard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.admin.AdvertisingListResponseDto;
import com.team.back.dto.response.admin.GetAdvertisingBoardListResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAdvertisingBoardLocationListResponsedto extends ResponseDto{
  
  private List<AdvertisingListResponseDto> advertisingboardList;

  private GetAdvertisingBoardLocationListResponsedto(String code, String message, List<AdvertisingBoardListResponseDto> advertisingBoardList){
    super(code, message);
    this.advertisingboardList = advertisingboardList;
  }

  public static ResponseEntity<GetAdvertisingBoardLocationListResponsedto> success(List<AdvertisingBoardListResponseDto> advertisingboardList) {
    GetAdvertisingBoardLocationListResponsedto result = new GetAdvertisingBoardLocationListResponsedto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS, advertisingboardList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
