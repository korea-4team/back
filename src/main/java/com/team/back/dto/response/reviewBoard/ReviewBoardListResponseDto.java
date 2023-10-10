package com.team.back.dto.response.reviewBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.ReviewBoardViewEntity;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewBoardListResponseDto  {
    
    private int boardNumber;
    private String title;
    private String contents;
    private String imageUrl;
    private int viewCount;
    private int commentCount;
    private int favoriteCount;
    private String writeDatetime;
    private String writerNickname;
    private String location;
    private String businessType;

    public ReviewBoardListResponseDto (ReviewBoardListResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.contents = resultSet.getContents();
        this.imageUrl = resultSet.getImageUrl();
        this.viewCount = resultSet.getViewCount();
        this.commentCount = resultSet.getCommentCount();
        this.favoriteCount = resultSet.getFavoriteCount();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerNickname = resultSet.getWriterNickname();
        this.location = resultSet.getLocation();
        this.businessType = resultSet.getBusinessType();
    }

    public static List<ReviewBoardListResponseDto> copyList(List<ReviewBoardListResultSet> resultSets) {
        List<ReviewBoardListResponseDto> boardList = new ArrayList<>();

        for (ReviewBoardListResultSet resultSet: resultSets) {
            ReviewBoardListResponseDto board = new ReviewBoardListResponseDto(resultSet);
            boardList.add(board);
        }

        return boardList;
    }

    public static List<ReviewBoardListResponseDto> copyEntityList(List<ReviewBoardViewEntity> reviewBoardViewEntities) {
        List<ReviewBoardListResponseDto> boardList = new ArrayList<>();

        for (ReviewBoardViewEntity entity: reviewBoardViewEntities) {
            ReviewBoardListResponseDto board = new ReviewBoardListResponseDto(entity);
            boardList.add(board);
        }

        return boardList;
    }

    public ReviewBoardListResponseDto (ReviewBoardViewEntity reviewBoardViewEntity) {
        this.boardNumber = reviewBoardViewEntity.getBoardNumber();
        this.title = reviewBoardViewEntity.getTitle();
        this.contents = reviewBoardViewEntity.getContents();
        this.imageUrl = reviewBoardViewEntity.getImageUrl();
        this.viewCount = reviewBoardViewEntity.getViewCount();
        this.commentCount = reviewBoardViewEntity.getCommentCount();
        this.favoriteCount = reviewBoardViewEntity.getFavoriteCount();
        this.writeDatetime = reviewBoardViewEntity.getWriteDatetime();
        this.writerNickname = reviewBoardViewEntity.getWriterNickname();
        this.location = reviewBoardViewEntity.getLocation();
        this.businessType = reviewBoardViewEntity.getBusinessType();
    }
    
}
