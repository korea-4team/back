package com.team.back.dto.response.banner;

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
public class GetMainBannerListResponseDto extends ResponseDto {
    
    private List<MainBannerListResponseDto> mainBannerList;

    private GetMainBannerListResponseDto(String code, String message, List<MainBannerListResponseDto> mainBannerList) {
        super(code, message);
        this.mainBannerList = mainBannerList;
    }

    public static ResponseEntity<GetMainBannerListResponseDto> success(List<MainBannerListResponseDto> mainBannerList) {
        GetMainBannerListResponseDto result = new GetMainBannerListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,mainBannerList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
