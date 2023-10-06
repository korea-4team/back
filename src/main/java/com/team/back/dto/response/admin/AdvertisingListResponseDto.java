package com.team.back.dto.response.admin;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisingListResponseDto {
	
	private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private int viewCount;
	private int shortReviewCount;
	private int favoriteCount;
	private String writeDatetime;
	private String writerEmail;
	private String writerNickname;
	private String besinessType;
	private String location;

	public AdvertisingListResponseDto (AdvertisingBoardResultSet resultSet) {
		this.boardNumber = resultSet.getBoardNumber();
		this.title = resultSet.getTitle();
		this.contents = resultSet.getContents();
		this.imageUrl = resultSet.getImageUrl();
		this.viewCount = resultSet.getViewCount();
		this.shortReviewCount = resultSet.getShortCommentCount();
		this.favoriteCount = resultSet.getFavoriteCount();
		this.writeDatetime = resultSet.getWriteDatetime();
		this.writerEmail = resultSet.getWriterEmail();
		this.writerNickname = resultSet.getWriterNickname();
	}

	public AdvertisingListResponseDto(AdvertisingViewEntity advertisingViewEntity) {
		this.boardNumber = advertisingViewEntity.getBoardNumber();
		this.title = advertisingViewEntity.getTitle();
		this.contents = advertisingViewEntity.getContents();
		this.imageUrl = advertisingViewEntity.getImageUrl();
		this.viewCount = advertisingViewEntity.getViewCount();
		this.shortReviewCount = advertisingViewEntity.getShort_review_count();
		this.favoriteCount = advertisingViewEntity.getFavorite();
		this.writeDatetime = advertisingViewEntity.getWriteDatetime();
		this.writerEmail = advertisingViewEntity.getWriterEmail();
		this.writerNickname = advertisingViewEntity.getWriterNickname();
		this.besinessType = advertisingViewEntity.getBusinessType();
		this.location = advertisingViewEntity.getLocation();
	}

	public static List<AdvertisingListResponseDto> copyList(List<AdvertisingBoardResultSet> resultSets) {
		List<AdvertisingListResponseDto> reviewBoardList = new ArrayList<>();

		for(AdvertisingBoardResultSet resultSet : resultSets) {
			AdvertisingListResponseDto  reviewBoard = new AdvertisingListResponseDto(resultSet);
			reviewBoardList.add(reviewBoard);
		}
		return reviewBoardList;
	}

	public static List<AdvertisingListResponseDto> copyEntityList(List<AdvertisingViewEntity> advertisingViewEntities) {
		List<AdvertisingListResponseDto> advertisingBoardList = new ArrayList<>();

		for (AdvertisingViewEntity entity: advertisingViewEntities) {
			AdvertisingListResponseDto advertisingBoard = new AdvertisingListResponseDto(entity);
			advertisingBoardList.add(advertisingBoard);
		}

		return advertisingBoardList;
		
	}
}
