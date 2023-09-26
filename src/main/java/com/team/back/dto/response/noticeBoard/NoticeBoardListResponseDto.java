package com.team.back.dto.response.noticeBoard;

import java.util.ArrayList;
import java.util.List;

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
	private String writerNickname;

	public NoticeBoardListResponseDto (NoticeBoardListResultSet resultSet) {
		this.boardNumber = resultSet.getBoardNumber();
		this.title = resultSet.getTitle();
		this.contents = resultSet.getContetns();
		this.imageUrl = resultSet.getImageUrl();
		this.writeDatetime = resultSet.getWriteDatetime();
		this.writerNickname = resultSet.getWriterNickname();
	}

	public static List<NoticeBoardListResponseDto> copyList(List<NoticeBoardListResultSet> resultSets) {
		List<NoticeBoardListResponseDto> noticeBoardList = new  ArrayList<>();
		
		for (NoticeBoardListResultSet resultSet : resultSets) {
			NoticeBoardListResponseDto noticeBoard = new NoticeBoardListResponseDto(resultSet);
			noticeBoardList.add(noticeBoard);
		}
		return noticeBoardList;
	}
}
