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
public class PostAdvertisingBoardResponseDto extends ResponseDto{

  private PostAdvertisingBoardResponseDto (String code, String message) {
    super(code,message);
  }

  public static ResponseEntity<PostAdvertisingBoardResponseDto> success() {
    PostAdvertisingBoardResponseDto result = new PostAdvertisingBoardResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistUser(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
