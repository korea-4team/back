package com.team.back.entity.resultSet;

public interface ReviewBoardListResultSet {

  int getBoardNumber();
  String getTitle();
  String getContents();
  String getImageUrl();
  int getViewCount();
  int getCommentCount();
  int getFavoriteCount();
  String getWriteDatetime();
  String getWriterNickname();
  String getWriterEmail();
  String getLocation();
  String getBusinessType();

}