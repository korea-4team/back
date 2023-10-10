package com.team.back.dto.request.advertisingBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostAdvertisingRequestDto {


  @NotBlank
  private String writerEmail;

  @NotBlank
  private int boardNumber;

  @NotBlank
  private String title;

  @NotBlank
  private String contents;
  
  private String imageUrl;

  @NotBlank
  private String location;

  @NotBlank
  private String businessType;
}
