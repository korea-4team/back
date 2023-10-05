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
public class GetAdvertisingBoardLocationListResponsedto extends ResponseDto{
  
  private List<GetAdvertisingboardResponseDto> advertisingBoardList;

  private GetAdvertisingBoardLocationListResponsedto(String code, String message, List<GetAdvertisingboardResponseDto> getAdvertisingboardResponseDtos){
    super(code, message);
    this.advertisingBoardList = advertisingBoardList;
  }

  public static ResponseEntity<GetAdvertisingBoardLocationListResponsedto> success(List<GetAdvertisingboardResponseDto> advertisingboardList) {
    GetAdvertisingBoardLocationListResponsedto result = new GetAdvertisingBoardLocationListResponsedto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS, advertisingboardList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
