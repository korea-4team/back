package com.team.back.dto.request.banner;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBannerRequestDto {
    
    @NotBlank
    private String imageUrl;

    private int sequence;

}
