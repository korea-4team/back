package com.team.back.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserRequestDto {
    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    private String telNumber;

    @NotBlank
    private String address;

    private String addressDetail;
}
