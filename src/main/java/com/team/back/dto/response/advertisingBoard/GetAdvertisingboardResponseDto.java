package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class GetAdvertisingboardResponseDto {

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

  public GetAdvertisingboardResponseDto(AdvertisingBoardResultSet resultSet){
    this.boardNumber = resultSet.getBoardNumber();
    this.title = resultSet.getTitle();
    this.contents = resultSet.getContents();
    this.image_url = resultSet.getImageUrl();
    this.view_count = resultSet.getViewCount();
    this.short_review_count = resultSet.getShortCommentCount();
    this.favorite_count = resultSet.getFavoriteCount();
    this.writeDatetime = resultSet.getWriteDatetime();
    this.writerEmail = resultSet.getWriterEmail();
    this.writerNickname = resultSet.getWriterNickname();
  }


  private GetAdvertisingboardResponseDto(AdvertisingViewEntity advertising_View_Entity) {
    this.boardNumber = advertising_View_Entity.getBoardNumber();
    this.title = advertising_View_Entity.getTitle();
    this.contents = advertising_View_Entity.getContents();
    this.image_url = advertising_View_Entity.getImageUrl();
    this.writeDatetime = advertising_View_Entity.getWriteDatetime();
    this.writerEmail = advertising_View_Entity.getWriterEmail();
    this.writerNickname = advertising_View_Entity.getWriterNickname();

  }

  public static List<GetAdvertisingboardResponseDto> copyList(List<AdvertisingBoardResultSet> resultSets) {
    List<GetAdvertisingboardResponseDto> advertisingboardList = new ArrayList<>();

    for (AdvertisingBoardResultSet resultSet: resultSets){
      GetAdvertisingboardResponseDto advertisingboard = new GetAdvertisingboardResponseDto(resultSet);
      advertisingboardList.add(advertisingboard);
    }
    return advertisingboardList;
  }

  public static List<GetAdvertisingboardResponseDto> copyEntityList(List<AdvertisingViewEntity> advertisingViewEntities){
    List<GetAdvertisingboardResponseDto> advertisingboardList = new ArrayList<>();

    for (AdvertisingViewEntity entity: advertisingViewEntities){
      GetAdvertisingboardResponseDto advertisingboard = new GetAdvertisingboardResponseDto(entity);
      advertisingboardList.add(advertisingboard);
    }

    return advertisingboardList;
  }
  
  
}
