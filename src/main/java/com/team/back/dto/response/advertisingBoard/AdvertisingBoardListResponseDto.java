package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisingBoardListResponseDto {

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
  private String location;
  private String businessType;

  public AdvertisingBoardListResponseDto (AdvertisingBoardResultSet resultSet){
    this.boardNumber = resultSet.getBoardNumber();
    this.title = resultSet.getTitle();
    this.contents = resultSet.getContents();
    this.imageUrl = resultSet.getImageUrl();
    this.viewCount = resultSet.getViewCount();
    this.shortReviewCount = resultSet.getShortReviewCount();
    this.favoriteCount = resultSet.getFavoriteCount();
    this.writeDatetime = resultSet.getWriteDatetime();
		this.writerEmail = resultSet.getWriterEmail();
    this.writerNickname = resultSet.getWriterNickname();
    this.location = resultSet.getLocation();
    this.businessType = resultSet.getBusinessType();

  }

  public AdvertisingBoardListResponseDto(AdvertisingViewEntity advertisingViewEntity){
    this.boardNumber = advertisingViewEntity.getBoardNumber();
    this.title = advertisingViewEntity.getTitle();
    this.contents = advertisingViewEntity.getContents();
    this.imageUrl = advertisingViewEntity.getImageUrl();
    this.viewCount = advertisingViewEntity.getViewCount();
    this.shortReviewCount = advertisingViewEntity.getShortReviewCount();
    this.favoriteCount = advertisingViewEntity.getFavoriteCount();
    this.writeDatetime = advertisingViewEntity.getWriteDatetime();
		this.writerEmail = advertisingViewEntity.getWriterEmail();
    this.writerNickname = advertisingViewEntity.getWriterNickname();
    this.location = advertisingViewEntity.getLocation();
    this.businessType = advertisingViewEntity.getBusinessType();
  }

  public static List<AdvertisingBoardListResponseDto> copyEntityList(List<AdvertisingViewEntity> advertisingViewEntities){
    List<AdvertisingBoardListResponseDto> advertisingBoardList = new ArrayList<>();

    for(AdvertisingViewEntity entity: advertisingViewEntities){
      AdvertisingBoardListResponseDto advertisingBoard = new AdvertisingBoardListResponseDto(entity);
      advertisingBoardList.add(advertisingBoard);
    }

    return advertisingBoardList;
  }

  public static List<AdvertisingBoardListResponseDto> copyList(List<AdvertisingBoardResultSet> resultSets) {
    List<AdvertisingBoardListResponseDto> advertisingBoardList = new ArrayList<>();

    for(AdvertisingBoardResultSet resultSet: resultSets){
      AdvertisingBoardListResponseDto advertisingBoard = new AdvertisingBoardListResponseDto(resultSet);
      advertisingBoardList.add(advertisingBoard);

    }

    return advertisingBoardList;

  }

  
}
