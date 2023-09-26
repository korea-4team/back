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
public class GetAdvertisingboard extends ResponseDto{

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


  private GetAdvertisingboard(String code, String message, AdvertisingViewEntity advertising_View_Entity){
    super(code,message);
    this.boardNumber = advertising_View_Entity.getBoardNumber();
    this.title = advertising_View_Entity.getTitle();
    this.contents = advertising_View_Entity.getContents();
    this.image_url = advertising_View_Entity.getImageUrl();
    this.writeDatetime = advertising_View_Entity.getWriteDatetime();
    this.writerEmail = advertising_View_Entity.getWriterEmail();
    this.writerNickname = advertising_View_Entity.getWriterNickname();

  }

  public static ResponseEntity<GetAdvertisingboard> success(AdvertisingViewEntity advertising_View_Entity){
    GetAdvertisingboard result = new GetAdvertisingboard(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertising_View_Entity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseDto.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
