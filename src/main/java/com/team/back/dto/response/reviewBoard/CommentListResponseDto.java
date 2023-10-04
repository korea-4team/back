package com.team.back.dto.response.reviewBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.CommentListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentListResponseDto {
    private String nickname;
    private String writeDatetime;
    private String contents;
    
    public CommentListResponseDto(CommentListResultSet resultSet) {
        this.nickname = resultSet.getNickname();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.contents = resultSet.getContnts();
    }

    public static List<CommentListResponseDto> copyList(List<CommentListResultSet> resultSets) {
        List<CommentListResponseDto> commentList = new ArrayList<>();

        for (CommentListResultSet resultSet: resultSets) {
            CommentListResponseDto commentItem = new CommentListResponseDto(resultSet);
            commentList.add(commentItem);
        }

        return commentList;
    }
}