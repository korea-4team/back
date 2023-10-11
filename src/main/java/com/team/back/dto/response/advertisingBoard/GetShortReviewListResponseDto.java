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
public class GetShortReviewListResponseDto extends ResponseDto{

  private List<ShortReviewResponseDto> shortList;

  private GetShortReviewListResponseDto(String code, String message, List<ShortReviewResponseDto> shortList) {
    super(code, message);
    this.shortList = shortList;
  }

  public static ResponseEntity<GetShortReviewListResponseDto> success(List<ShortReviewResponseDto> shortList){
    GetShortReviewListResponseDto result = new GetShortReviewListResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,shortList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> notAdminId() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
  
}
