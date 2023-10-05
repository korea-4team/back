package com.team.back.dto.response.admin;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserViewEntity;
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

	// 유저 상세보기
	public UserListResponseDto (UserViewEntity userViewEntity) {
		this.email = userViewEntity.getUserEmail();
		this.password = userViewEntity.getUserPassword();
		this.nickname = userViewEntity.getUserNickname();
		this.address = userViewEntity.getUserAddress();
		this.addressDetail = userViewEntity.getUserAddressDetail();
		this.role = userViewEntity.getUserRole();
		this.telNumber = userViewEntity.getUserTelNumber();
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

	// 유저 상세 보기
	public static List<UserListResponseDto> copyEntityList(List<UserViewEntity> userViewEntities) {
		List<UserListResponseDto> userDetailList = new ArrayList<>();

		for (UserViewEntity entity : userViewEntities) {
			UserListResponseDto userList = new UserListResponseDto(entity);
			userDetailList.add(userList);
		}
		
		return userDetailList;
	}

}
