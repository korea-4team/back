package com.team.back.entity.resultSet;

public interface NoticeBoardListResultSet {
	int getBoardNumber();
	String getTitle();
	String getContents();
	String getImageUrl();
	String getWriteDatetime();
	String getWriterEmail();
	String getWriterNickname();
}
