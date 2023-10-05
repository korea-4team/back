package com.team.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.Getter;

@Getter
public class AccountFindEmailResponseDto extends ResponseDto {
    
    private String email;

    private AccountFindEmailResponseDto(String email) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = email;
    }

    public static ResponseEntity<AccountFindEmailResponseDto> success(String email) {
        AccountFindEmailResponseDto result = new AccountFindEmailResponseDto(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
