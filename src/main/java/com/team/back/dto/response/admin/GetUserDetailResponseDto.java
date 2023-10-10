package com.team.back.dto.response.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.UserEntity;
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

	private GetUserDetailResponseDto(String code, String message, UserEntity userEntity) {
		super(code, message);
		this.email = userEntity.getEmail();
		this.password = userEntity.getPassword();
		this.nickname = userEntity.getNickname();
		this.address = userEntity.getAddress();
		this.addressDetail = userEntity.getAddressDetail();
		this.role = userEntity.getRole();
		this.telNumber = userEntity.getTelNumber();
	}

	public static ResponseEntity<GetUserDetailResponseDto> success(UserEntity userEntity) {
		GetUserDetailResponseDto result = new GetUserDetailResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> noExistedUser() {
		ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
