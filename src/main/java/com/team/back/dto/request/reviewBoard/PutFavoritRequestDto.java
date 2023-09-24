package com.team.back.dto.request.reviewBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutFavoritRequestDto {
  
  @NotBlank
  private String userEmail;
}
