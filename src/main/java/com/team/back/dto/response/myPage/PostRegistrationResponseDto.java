package com.team.back.dto.response.myPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.Getter;

@Getter
public class PostRegistrationResponseDto extends ResponseDto {
    
    private PostRegistrationResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostRegistrationResponseDto> success() {
        PostRegistrationResponseDto result = new PostRegistrationResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> existStoreNumber() {
        ResponseDto result = new ResponseDto(ResponseCode.EXISTED_STORE_NUMBER, ResponseMessage.EXISTED_STORE_NUMBER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
