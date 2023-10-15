package com.team.back.dto.response.advertisingBoard;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.AdvertisingMenuEntity;
import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.TagEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class GetAdvertisingboardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private int viewCount;
  private int shortReviewCount;
  private int favoriteCount;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private String businessType;
  private String location;
  private List<String> tagList;
  private List<AdvertisingBoardMenuResponseDto> menuList;

  private GetAdvertisingboardResponseDto(String code, String message, AdvertisingViewEntity advertisingViewEntity, List<TagEntity> tagEntities, List<AdvertisingMenuEntity> menuEntities){
    super(code, message);

    List<String> tagwordList = new ArrayList<>();

    for(TagEntity tag : tagEntities) {
      String tagword = tag.getTagWord();
      tagwordList.add(tagword);
    }

    List<AdvertisingBoardMenuResponseDto> menuBoardList = new ArrayList<>();

    for(AdvertisingMenuEntity menu : menuEntities) {

      AdvertisingBoardMenuResponseDto menuBoard = new AdvertisingBoardMenuResponseDto(menu);
      menuBoardList.add(menuBoard);
      
    }

    this.boardNumber = advertisingViewEntity.getBoardNumber();
    this.title = advertisingViewEntity.getTitle();
    this.contents = advertisingViewEntity.getContents();
    this.imageUrl = advertisingViewEntity.getImageUrl();
    this.writeDatetime = advertisingViewEntity.getWriteDatetime();
    this.writerEmail = advertisingViewEntity.getWriterEmail();
    this.writerNickname = advertisingViewEntity.getWriterNickname();
    this.viewCount = advertisingViewEntity.getViewCount();
    this.shortReviewCount = advertisingViewEntity.getShortReviewCount();
    this.favoriteCount = advertisingViewEntity.getFavoriteCount();
    this.businessType = advertisingViewEntity.getBusinessType();
    this.location = advertisingViewEntity.getLocation();
    this.tagList = tagwordList;
    this.menuList = menuBoardList;
  }

  public static ResponseEntity<GetAdvertisingboardResponseDto> success(AdvertisingViewEntity advertisingViewEntity, List<TagEntity> tagEntities, List<AdvertisingMenuEntity> menuEntities){
    GetAdvertisingboardResponseDto result = new GetAdvertisingboardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertisingViewEntity, tagEntities, menuEntities);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
