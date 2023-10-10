package com.team.back.entity.resultSet;

public interface UserCommentListResultSet {
    int getCommentNumber();
    String getContents();
    String getWriteDatetime();
    int getBoardNumber();
    String getTitle();
    String getImageUrl();
}
