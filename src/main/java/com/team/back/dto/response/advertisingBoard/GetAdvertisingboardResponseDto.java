package com.team.back.dto.response.advertisingBoard;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.AdvertisingViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class GetAdvertisingboardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String contents;
  private String image_url;
  private int view_count;
  private int short_review_count;
  private int favorite_count;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;

  
  private GetAdvertisingboardResponseDto(String code, String message, AdvertisingViewEntity advertisingViewEntity){
    super(code, message);
    this.boardNumber = advertisingViewEntity.getBoardNumber();
    this.title = advertisingViewEntity.getTitle();
    this.contents = advertisingViewEntity.getContents();
    this.image_url = advertisingViewEntity.getImageUrl();
    this.writeDatetime = advertisingViewEntity.getWriteDatetime();
    this.writerEmail = advertisingViewEntity.getWriterEmail();
    this.writerNickname = advertisingViewEntity.getWriterNickname();
    this.view_count = advertisingViewEntity.getViewCount();
    this.short_review_count = advertisingViewEntity.getShort_review_count();
    this.favorite_count = advertisingViewEntity.getFavorite();  
  }

  public static ResponseEntity<GetAdvertisingboardResponseDto> success(AdvertisingViewEntity advertisingViewEntity){
    GetAdvertisingboardResponseDto result = new GetAdvertisingboardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertisingViewEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
