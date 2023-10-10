package com.team.back.dto.request.advertisingBoard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAdvertisingMenuRequestDto {

	@NotNull
	private Integer menuNumber;

	@NotBlank
	private String title;
	
	@NotBlank
	private String contents;
	
	@NotBlank
	private String imageUrl;
	
	@NotBlank
	private String price;

	@NotNull
	private Integer boardNumber;
}
