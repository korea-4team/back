package com.team.back.entity.resultSet;

public interface ShortReviewResultSet {

  int getBoardNumber();
  int score();
  String getWriterNickname();
  String getWriterEmail();
  String getWriteDatetime();
  String getContents();
  
}
