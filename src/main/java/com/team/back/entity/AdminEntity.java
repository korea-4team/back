package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.auth.SignUpRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="admin")
@Table(name="admin")
public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String adminId;

	private String adminPassword;

	private String adminNickname;

	public AdminEntity(SignUpRequestDto dto) {
		this.adminId = dto.getEmail();
		this.adminPassword = dto.getPassword();
		this.adminNickname = dto.getNickname();
	}
	
}
