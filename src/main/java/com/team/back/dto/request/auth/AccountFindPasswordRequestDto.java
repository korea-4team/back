package com.team.back.dto.request.auth;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountFindPasswordRequestDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String telNumber;
}
