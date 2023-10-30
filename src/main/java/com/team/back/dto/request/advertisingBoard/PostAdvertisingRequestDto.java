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
  
  private List<String> imageUrls;

  @NotBlank
  private String location;

  @NotBlank
  private String businessType;

  List<String> tagList;
  
  List<PostAdvertisingMenuRequestDto> menuList;

  PostAdvertisingDetailRequestDto dtail;



}
