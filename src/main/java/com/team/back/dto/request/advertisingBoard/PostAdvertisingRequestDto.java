package com.team.back.dto.request.advertisingBoard;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAdvertisingRequestDto {

  @NotBlank
  private String title;

  @NotBlank
  private String contents;
  
  private String imageUrl;

  @NotBlank
  private String location;

  @NotBlank
  private String businessType;

  @NotBlank
  private String tagWord;
  
  List<PostAdvertisingMenuRequestDto> menuList;


}
