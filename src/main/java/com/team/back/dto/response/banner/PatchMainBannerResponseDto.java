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
public class PatchMainBannerResponseDto extends ResponseDto {
    
    private PatchMainBannerResponseDto (String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PatchMainBannerResponseDto> success() {
        PatchMainBannerResponseDto result = new PatchMainBannerResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<PatchMainBannerResponseDto> notAdminId() {
        PatchMainBannerResponseDto result = new PatchMainBannerResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<PatchMainBannerResponseDto> noExistedBoard() {
        PatchMainBannerResponseDto result = new PatchMainBannerResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
