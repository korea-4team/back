package com.team.back.dto.response.reviewBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.CommentViewEntity;
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
        this.contents = resultSet.getContents();
    }

    public static List<CommentListResponseDto> copyList(List<CommentListResultSet> resultSets) {
        List<CommentListResponseDto> commentList = new ArrayList<>();

        for (CommentListResultSet resultSet: resultSets) {
            CommentListResponseDto commentItem = new CommentListResponseDto(resultSet);
            commentList.add(commentItem);
        }

        return commentList;
    }

    public CommentListResponseDto (CommentViewEntity commentViewEntity) {
        this.contents = commentViewEntity.getContents();
        this.nickname = commentViewEntity.getUserNickname();
        this.writeDatetime = commentViewEntity.getWriteDatetime();
    }

    public static List<CommentListResponseDto> copyEntityList(List<CommentViewEntity> commentViewEntities) {
        List<CommentListResponseDto> commentList = new ArrayList<>();

        for (CommentViewEntity entity : commentViewEntities) {
            CommentListResponseDto comment = new CommentListResponseDto(entity);
            commentList.add(comment);
        }

        return commentList;

    }
}
