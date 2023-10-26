package com.team.back.dto.response.eventBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.EventBoardViewEntity;
import com.team.back.entity.resultSet.EventBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventBoardListResponseDto {
    private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String writeDatetime;
	private String adminEmail;
	private String adminNickname;
    
    public EventBoardListResponseDto(EventBoardListResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.contents = resultSet.getContents();
        this.imageUrl = resultSet.getImageUrl();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.adminEmail = resultSet.getWriterEmail();
        this.adminNickname = resultSet.getWriterNickname();
    }

    public EventBoardListResponseDto(EventBoardViewEntity eventBoardViewEntity) {
        this.boardNumber = eventBoardViewEntity.getBoardNumber();
        this.title = eventBoardViewEntity.getTitle();
        this.contents = eventBoardViewEntity.getContents();
        this.imageUrl = eventBoardViewEntity.getImageUrl();
        this.writeDatetime = eventBoardViewEntity.getWriteDatetime();
        this.adminEmail = eventBoardViewEntity.getWriterEmail();
        this.adminNickname = eventBoardViewEntity.getWriterNickname();
    }

    public static List<EventBoardListResponseDto> copyList(List<EventBoardListResultSet> resultSets) {
        List<EventBoardListResponseDto> eventBoardList = new ArrayList<>();

        for (EventBoardListResultSet resultSet: resultSets) {
            EventBoardListResponseDto eventBoard = new EventBoardListResponseDto(resultSet);
            eventBoardList.add(eventBoard);
        }
        return eventBoardList;
    }

    public static List<EventBoardListResponseDto> copyEntityList(List<EventBoardViewEntity> eventBoardViewEntities) {
        List<EventBoardListResponseDto> eventBoardList = new ArrayList<>();

        for(EventBoardViewEntity entity: eventBoardViewEntities) {
            EventBoardListResponseDto eventBoard = new EventBoardListResponseDto(entity);
            eventBoardList.add(eventBoard);
        }
        return eventBoardList;
    }
}
