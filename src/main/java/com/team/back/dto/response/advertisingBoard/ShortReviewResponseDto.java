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
  private int shortReviewNumber;
  private String contents;
  private double score;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;


  public ShortReviewResponseDto (ShortReviewResultSet resultSet){
    this.shortReviewNumber = resultSet.getShortReviewNumber();
    this.contents = resultSet.getContents();
    this.writerEmail = resultSet.getWriterEmail();
    this.writeDatetime = resultSet.getWriteDatetime();
    this.writerNickname = resultSet.getWriterNickname();
    this.score = resultSet.getScore();
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
    this.shortReviewNumber = advertisingShortReviewEntity.getBoardNumber();
    this.contents = advertisingShortReviewEntity.getContents();
    this.writeDatetime = advertisingShortReviewEntity.getWriteDatetime();
    this.writerEmail = advertisingShortReviewEntity.getUserEmail();
  }

  
}
