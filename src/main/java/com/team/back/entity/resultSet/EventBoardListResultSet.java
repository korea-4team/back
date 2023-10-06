package com.team.back.entity.resultSet;

public interface EventBoardListResultSet {
    int getBoardNumber();
	String getTitle();
	String getContents();
	String getImageUrl();
	String getWriteDatetime();
	String getWriterEmail();
	String getWriterNickname();
}
