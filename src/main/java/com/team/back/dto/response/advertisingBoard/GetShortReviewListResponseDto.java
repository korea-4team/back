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

  private List<PostShortReviewResponseDto> shortReviewList;

  private GetShortReviewListResponseDto(String code, String message, List<PostShortReviewResponseDto> shortReviewList) {
    super(code, message);
    this.shortReviewList = shortReviewList;
  }

  public static ResponseEntity<GetShortReviewListResponseDto> success(List<PostShortReviewResponseDto> shortReviewList){
    GetShortReviewListResponseDto result = new GetShortReviewListResponseDto(ResponseCode.SUCCESS,ResponseMessage.SUCCESS,shortReviewList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
}
