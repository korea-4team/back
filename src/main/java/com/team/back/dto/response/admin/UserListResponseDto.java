package com.team.back.dto.response.admin;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.UserListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserListResponseDto {
	
	private String email;
	private String password;
	private String nickname;
	private String address;
	private String addressDetail;
	private String role;
	private String telNumber;

	// 유저 리스트 보기
	public UserListResponseDto (UserListResultSet resultSet) {
		this.email = resultSet.getEmail();
		this.password = resultSet.getPassword();
		this.nickname = resultSet.getNickname();
		this.address = resultSet.getAddress();
		this.addressDetail = resultSet.getAddressDetail();
		this.role = resultSet.getRole();
		this.telNumber = resultSet.getTelNumber();
	}

	// 유저 리스트 보기
	public static List<UserListResponseDto> copyList(List<UserListResultSet> resultSets){
		List<UserListResponseDto> userList = new ArrayList<>();

		for (UserListResultSet resultSet : resultSets) {
			UserListResponseDto user = new UserListResponseDto(resultSet);
			userList.add(user);
		}
		return userList;
	}



}
