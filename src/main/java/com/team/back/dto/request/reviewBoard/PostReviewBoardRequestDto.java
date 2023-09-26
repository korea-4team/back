package com.team.back.dto.request.reviewBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReviewBoardRequestDto {
  
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
