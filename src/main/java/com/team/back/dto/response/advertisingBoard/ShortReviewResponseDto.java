package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingShortReviewEntity;
import com.team.back.entity.resultSet.ShortReviewResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShortReviewResponseDto {

  private int boardNumber;
  private String contents;
  private int score;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;


  public ShortReviewResponseDto (ShortReviewResultSet resultSet){
    this.boardNumber = resultSet.getboardNumber();
    this.contents = resultSet.getContents();
    this.writeDatetime = resultSet.getWriteDatetime();
    this.writerNickname = resultSet.getWriterNickname();
  }

  public static List<ShortReviewResponseDto> copyList(List<ShortReviewResultSet> resultSets){
    List<ShortReviewResponseDto> shortList = new ArrayList<>();

    for (ShortReviewResultSet resultSet : resultSets){
      ShortReviewResponseDto shortreview = new ShortReviewResponseDto(resultSet);
      shortList.add(shortreview);
    }

    return shortList;
    
  }

  public static List<ShortReviewResponseDto> copyEntityList(List<AdvertisingShortReviewEntity> advertisingShortReviewEntities){
    List<ShortReviewResponseDto> shortList = new ArrayList<>();

    for (AdvertisingShortReviewEntity entity: advertisingShortReviewEntities) {
      ShortReviewResponseDto shortreview = new ShortReviewResponseDto(entity);
      shortList.add(shortreview);
    }
    return shortList;
  }

  public ShortReviewResponseDto (AdvertisingShortReviewEntity advertisingShortReviewEntity){
    this.boardNumber = advertisingShortReviewEntity.getBoardNumber();
    this.contents = advertisingShortReviewEntity.getContents();
    this.writeDatetime = advertisingShortReviewEntity.getWriteDatetime();
    this.writerEmail = advertisingShortReviewEntity.getUserEmail();
  }

  
}
