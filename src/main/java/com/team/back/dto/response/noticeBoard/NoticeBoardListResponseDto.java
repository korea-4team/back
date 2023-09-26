package com.team.back.dto.response.noticeBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.NoticeBoardViewEntity;
import com.team.back.entity.resultSet.NoticeBoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeBoardListResponseDto {
	private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String writeDatetime;
	private String writerEmail;
	private String writerNickname;

	public NoticeBoardListResponseDto (NoticeBoardListResultSet resultSet) {
		this.boardNumber = resultSet.getBoardNumber();
		this.title = resultSet.getTitle();
		this.contents = resultSet.getContents();
		this.imageUrl = resultSet.getImageUrl();
		this.writeDatetime = resultSet.getWriteDatetime();
		this.writerEmail = resultSet.getWriterEmail();
		this.writerNickname = resultSet.getWriterNickname();
	}

	public NoticeBoardListResponseDto (NoticeBoardViewEntity noticeBoardViewEntity) {
		this.boardNumber = noticeBoardViewEntity.getBoardNumber();
		this.title = noticeBoardViewEntity.getTitle();
		this.contents = noticeBoardViewEntity.getContents();
		this.imageUrl = noticeBoardViewEntity.getImageUrl();
		this.writeDatetime = noticeBoardViewEntity.getWriteDatetime();
		this.writerEmail = noticeBoardViewEntity.getWriterEmail();
		this.writerNickname = noticeBoardViewEntity.getWriterNickname();
	}

	public static List<NoticeBoardListResponseDto> copyList(List<NoticeBoardListResultSet> resultSets) {
		List<NoticeBoardListResponseDto> noticeBoardList = new  ArrayList<>();
		
		for (NoticeBoardListResultSet resultSet : resultSets) {
			NoticeBoardListResponseDto noticeBoard = new NoticeBoardListResponseDto(resultSet);
			noticeBoardList.add(noticeBoard);
		}
		return noticeBoardList;
	}

	public static List<NoticeBoardListResponseDto> copyEntityList(List<NoticeBoardViewEntity> noticeBoardViewEntites) {
		List<NoticeBoardListResponseDto> noticeBoardList = new ArrayList<>();

		for (NoticeBoardViewEntity entity : noticeBoardViewEntites) {
			NoticeBoardListResponseDto noticeBoard = new NoticeBoardListResponseDto(entity);
			noticeBoardList.add(noticeBoard);
		}
		return noticeBoardList;
	}
}
