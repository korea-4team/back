package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutAdvertisingFavoriteListResponseDto {
  private String email;

  public PutAdvertisingFavoriteListResponseDto(UserEntity userEntity){
    this.email = userEntity.getEmail();
  }

  public static List<PutAdvertisingFavoriteListResponseDto> copyEntityList(List<UserEntity> userEntities){
    List<PutAdvertisingFavoriteListResponseDto> adfavoriteList = new ArrayList<>();

    for (UserEntity userEntity: userEntities){
      PutAdvertisingFavoriteListResponseDto adfavoriteitem = new PutAdvertisingFavoriteListResponseDto(userEntity);
      adfavoriteList.add(adfavoriteitem);
    }
    return adfavoriteList;
  }
  
}
