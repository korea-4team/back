package com.team.back.dto.request.advertisingBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostShortReviewRequestDto {

  @NotBlank
  private String contents;

  private double score;
  
}
