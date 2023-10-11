package com.team.back.entity.resultSet;

public interface AdvertisingBoardResultSet {

  int getBoardNumber();
  String getTitle();
  String getContents();
  String getImageUrl();
  int getViewCount();
  int getShortCommentCount();
  int getFavoriteCount();
  String getWriteDatetime();
  String getWriterNickname();
  String getWriterEmail();
  String getTagWord();
  String getLocation();
  String getBusinessType();
  
}
