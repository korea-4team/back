package com.team.back.dto.response.myPage;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.UserCommentListResultSet;

import lombok.Getter;

@Getter
public class UserReviewCommentDto {
    private int commentNumber;
    private String contents;
    private String writeDatetime;
    private int boardNumber;
    private String title;
    private String imageUrl;

    private UserReviewCommentDto(UserCommentListResultSet resultSet) {
        this.commentNumber = resultSet.getCommentNumber();
        this.contents = resultSet.getContents();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.imageUrl = resultSet.getImageUrl();
    }

    public static List<UserReviewCommentDto> copyList(List<UserCommentListResultSet> resultSets) {
        List<UserReviewCommentDto> list = new ArrayList<>();
        for (UserCommentListResultSet resultSet: resultSets) {
            UserReviewCommentDto dto = new UserReviewCommentDto(resultSet);
            list.add(dto);
        }
        return list;
    }
}
