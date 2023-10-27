package com.team.back.dto.response.advertisingBoard;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.AdvertisingBoardImageEntity;
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
  private List<String> imageUrls;
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
  private String tagWord;


  private GetAdvertisingboardResponseDto(String code, String message, AdvertisingViewEntity advertisingViewEntity, List<TagEntity> tagEntities, List<AdvertisingBoardMenuResponseDto> menuList, List<AdvertisingBoardImageEntity> imageEntities){
    super(code, message);

    List<String> tagwordList = new ArrayList<>();

    for(TagEntity tag : tagEntities) {
      String tagword = tag.getTagWord();
      tagwordList.add(tagword);
    }

    List<String> imageUrls = new ArrayList<>();

    for(AdvertisingBoardImageEntity imageEntity : imageEntities) {
      String imageUrl = imageEntity.getImageUrl();
      imageUrls.add(imageUrl);
    }

    this.boardNumber = advertisingViewEntity.getBoardNumber();
    this.title = advertisingViewEntity.getTitle();
    this.contents = advertisingViewEntity.getContents();
    this.imageUrls = imageUrls;
    this.writeDatetime = advertisingViewEntity.getWriteDatetime();
    this.writerEmail = advertisingViewEntity.getWriterEmail();
    this.writerNickname = advertisingViewEntity.getWriterNickname();
    this.viewCount = advertisingViewEntity.getViewCount();
    this.shortReviewCount = advertisingViewEntity.getShortReviewCount();
    this.favoriteCount = advertisingViewEntity.getFavoriteCount();  
    this.location = advertisingViewEntity.getLocation();
    this.businessType = advertisingViewEntity.getBusinessType();
    this.tagList = tagwordList;
    this.menuList = menuList;
  }

  public static ResponseEntity<GetAdvertisingboardResponseDto> success(AdvertisingViewEntity advertisingViewEntity, List<TagEntity> tagEntities, List<AdvertisingBoardMenuResponseDto> menuList, List<AdvertisingBoardImageEntity> imageEntities){
    GetAdvertisingboardResponseDto result = new GetAdvertisingboardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertisingViewEntity, tagEntities, menuList, imageEntities);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedBoard(){
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
