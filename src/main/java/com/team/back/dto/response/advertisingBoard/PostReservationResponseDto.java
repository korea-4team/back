package com.team.back.dto.response.advertisingBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

public class PostReservationResponseDto extends ResponseDto{
  private PostReservationResponseDto (String code, String message){
    super(code, message);

   }

   public static ResponseEntity<PostReservationResponseDto> success(){
    PostReservationResponseDto result = new PostReservationResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(result);
   }

   public static ResponseEntity<ResponseDto> noExistedUser(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
   }

   public static ResponseEntity<ResponseDto> noExistedBoard(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD,ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
   }
}
