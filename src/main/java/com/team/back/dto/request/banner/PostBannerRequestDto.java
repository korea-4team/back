package com.team.back.dto.request.banner;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBannerRequestDto {
    
    @NotBlank
    private String imageUrl;
    
    @NotNull
    private Integer sequence;

}
