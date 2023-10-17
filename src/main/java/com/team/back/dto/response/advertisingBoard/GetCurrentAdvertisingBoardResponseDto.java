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
public class GetCurrentAdvertisingBoardResponseDto extends ResponseDto{

  private List<AdvertisingBoardListResponseDto> advertisingboardList;

  private GetCurrentAdvertisingBoardResponseDto(String code, String message, List<AdvertisingBoardListResponseDto> advertisingboardList){
    super(code, message);
    this.advertisingboardList = advertisingboardList;
  }

  public static ResponseEntity<GetCurrentAdvertisingBoardResponseDto> success(List<AdvertisingBoardListResponseDto> advertisingboardList) {
    GetCurrentAdvertisingBoardResponseDto result = new GetCurrentAdvertisingBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertisingboardList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> notAdminId() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
