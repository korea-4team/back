package com.team.back.dto.response.advertisingBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteAdvertisingBoardResponseDto extends ResponseDto{

  private DeleteAdvertisingBoardResponseDto(String code, String message){
    super(code,message);
  }

  public static ResponseEntity<DeleteAdvertisingBoardResponseDto> success(){
    DeleteAdvertisingBoardResponseDto result = new DeleteAdvertisingBoardResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noPerMission(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
