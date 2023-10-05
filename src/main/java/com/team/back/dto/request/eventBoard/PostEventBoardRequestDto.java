package com.team.back.dto.request.eventBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostEventBoardRequestDto {

    @NotBlank
	private String title;

	@NotBlank
	private String contents;

	private String imageUrl;
}
