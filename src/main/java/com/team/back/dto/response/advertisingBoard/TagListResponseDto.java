package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.TagEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TagListResponseDto {
	
	private String tagWord;
	private int boardNumber;

	public TagListResponseDto(TagEntity tagEntity) {
		this.tagWord = tagEntity.getTagWord();
		this.boardNumber = tagEntity.getBoardNumber();
	}

	public static List<TagListResponseDto> copyEntityList(List<TagEntity> tagEntities) {
		List <TagListResponseDto> tagWordList = new ArrayList<>();

		for(TagEntity entity : tagEntities) {
			TagListResponseDto tagWord = new TagListResponseDto(entity);
			tagWordList.add(tagWord);
		}
		return tagWordList;
	}
}
