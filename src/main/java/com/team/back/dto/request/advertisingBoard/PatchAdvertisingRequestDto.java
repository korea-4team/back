package com.team.back.dto.request.advertisingBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchAdvertisingRequestDto {

  @NotBlank
  private String title;

  @NotBlank
  private String contents;

  private String imageUrl;

  private String tagWord;
  
  
}
