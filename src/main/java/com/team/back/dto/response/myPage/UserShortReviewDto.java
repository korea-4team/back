package com.team.back.dto.response.myPage;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.UserShortReviewListResultSet;

import lombok.Getter;

@Getter
public class UserShortReviewDto {
    private int shortReviewNumber;
    private String writeDatetime;
    private String contents;
    private String imageUrl;
    private String socore;
    private int boardNumber;
    private String boardTitle;
    private String boardContents;
    private String boardImageUrl;

    private UserShortReviewDto(UserShortReviewListResultSet resultSet) {
        this.shortReviewNumber = resultSet.getShortReviewNumber();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.contents = resultSet.getContents();
        this.imageUrl = resultSet.getImageUrl();
        this.socore = resultSet.getSocore();
        this.boardNumber = resultSet.getBoardNumber();
        this.boardTitle = resultSet.getBoardTitle();
        this.boardContents = resultSet.getBoardContents();
        this.boardImageUrl = resultSet.getBoardImageUrl();
    }

    public static List<UserShortReviewDto> copyList(List<UserShortReviewListResultSet> resultSets) {
        List<UserShortReviewDto> list = new ArrayList<>();
        for (UserShortReviewListResultSet resultSet: resultSets) {
            UserShortReviewDto dto = new UserShortReviewDto(resultSet);
            list.add(dto);
        }
        return list;
    }
}
