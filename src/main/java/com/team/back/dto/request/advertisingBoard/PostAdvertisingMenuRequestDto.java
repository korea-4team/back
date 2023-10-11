package com.team.back.dto.request.advertisingBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAdvertisingMenuRequestDto {

	private String title;
	
	private String contents;
	
	private String imageUrl;
	
	private String price;
}
