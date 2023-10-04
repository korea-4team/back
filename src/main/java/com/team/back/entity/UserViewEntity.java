package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_view")
@Table(name = "user_view")
public class UserViewEntity {
	@Id
	private String userEmail;
	private String userPassword;
	private String userNickname;
	private String userAddress;
	private String userAddressDetail;
	private String userRole;
	private String userTelNumber;
	
}
