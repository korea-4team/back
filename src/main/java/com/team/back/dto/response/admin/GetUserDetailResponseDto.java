package com.team.back.dto.response.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.UserViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetUserDetailResponseDto extends ResponseDto {
	
	private String email;
	private String password;
	private String nickname;
	private String address;
	private String addressDetail;
	private String role;
	private String telNumber;

	private GetUserDetailResponseDto(String code, String message, UserViewEntity userViewEntity) {
		super(code, message);
		this.email = userViewEntity.getUserEmail();
		this.password = userViewEntity.getUserPassword();
		this.nickname = userViewEntity.getUserNickname();
		this.address = userViewEntity.getUserAddress();
		this.addressDetail = userViewEntity.getUserAddressDetail();
		this.role = userViewEntity.getUserRole();
		this.telNumber = userViewEntity.getUserTelNumber();
	}

	public static ResponseEntity<GetUserDetailResponseDto> success(UserViewEntity userViewEntity) {
		GetUserDetailResponseDto result = new GetUserDetailResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userViewEntity);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> noExistedUser() {
		ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
