package com.team.back.dto.response.banner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.BannerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMainBannerDetailResponseDto extends ResponseDto {
    
    private int bannerNumber;
    private String imageUrl;
    private int sequence;
    private String writeDatetime;
    private String writerEmail;
    private int eventBoardNumber;

    private GetMainBannerDetailResponseDto(String code, String message, BannerEntity bannerEntity) {
        super(code, message);
        this.bannerNumber = bannerEntity.getBannerNumber();
        this.imageUrl = bannerEntity.getImageUrl();
        this.sequence = bannerEntity.getSequence();
        this.writeDatetime = bannerEntity.getWriteDatetime();
        this.writerEmail = bannerEntity.getWriterEmail();
        this.eventBoardNumber = bannerEntity.getEventBoardNumber();
    }

    public static ResponseEntity<? super GetMainBannerDetailResponseDto> success(BannerEntity bannerEntity) {
        GetMainBannerDetailResponseDto result = new GetMainBannerDetailResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, bannerEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }

    public static ResponseEntity<ResponseDto> noExistedBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
