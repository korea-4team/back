package com.team.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.AdminEntity;
import com.team.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignInUserResponseDto extends ResponseDto {
    
    private String email;
    private String nickname;
    private String address;
    private String addressDetail;
    private String role;
    private String telNumber;

    private GetSignInUserResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.address = userEntity.getAddress();
        this.addressDetail = userEntity.getAddressDetail();
        this.role = userEntity.getRole();
        this.telNumber = userEntity.getTelNumber();
    }

    private GetSignInUserResponseDto(AdminEntity adminEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = adminEntity.getAdminId();
        this.nickname = adminEntity.getAdminNickname();
        this.role = adminEntity.getAdminId();
    }

    public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity) {
        GetSignInUserResponseDto result = new GetSignInUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<GetSignInUserResponseDto> success(AdminEntity adminEntity) {
        GetSignInUserResponseDto result = new GetSignInUserResponseDto(adminEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
