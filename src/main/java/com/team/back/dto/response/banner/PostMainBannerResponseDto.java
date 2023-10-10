package com.team.back.dto.response.banner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMainBannerResponseDto extends ResponseDto {
    private PostMainBannerResponseDto (String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PostMainBannerResponseDto> success() {
        PostMainBannerResponseDto result = new PostMainBannerResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
		PostMainBannerResponseDto result = new PostMainBannerResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
