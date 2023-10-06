package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.auth.SignUpRequestDto;
import com.team.back.dto.request.myPage.PatchUserRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="user")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String address;
    private String addressDetail;
    private String role;
    private String telNumber;

    public UserEntity(SignUpRequestDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.role = "user";
        this.telNumber = dto.getTelNumber();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void patchUser(PatchUserRequestDto dto) {
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.telNumber = dto.getTelNumber();
    } 
}
