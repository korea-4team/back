package com.team.back.dto.request.noticeBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchNoticeBoardRequestDto {
	
	@NotBlank
	private String title;

	@NotBlank
	private String contents;

	private String imageUrl;
}
