package com.team.back.dto.request.advertisingBoard;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAdvertisingMenuRequestDto {

	private String title;
	
	private String contents;
	
	private List<String> imageUrls;
	
	private String price;
}
