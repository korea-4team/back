package com.team.back.dto.response.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAdvertisingBoardListResponseDto extends ResponseDto {
	
	private List<AdvertisingListResponseDto> advertigingBoardList;

	private GetAdvertisingBoardListResponseDto(String code, String message, List<AdvertisingListResponseDto> advertisingBoardList) {
		super(code, message);
		this.advertigingBoardList = advertisingBoardList;
	}

	public static ResponseEntity<? super GetAdvertisingBoardListResponseDto> success(List<AdvertisingListResponseDto> advertisingBoardList) {
		GetAdvertisingBoardListResponseDto result = new GetAdvertisingBoardListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, advertisingBoardList);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
