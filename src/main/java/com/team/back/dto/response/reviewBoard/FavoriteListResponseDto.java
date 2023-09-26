package com.team.back.dto.response.reviewBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FavoriteListResponseDto {
    private String email;

    public FavoriteListResponseDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
    }

    public static List<FavoriteListResponseDto> copyEntityList(List<UserEntity> userEntities) {
        List<FavoriteListResponseDto> favoriteList = new ArrayList<>();

        for (UserEntity userEntity: userEntities) {
            FavoriteListResponseDto favoriteItem = new FavoriteListResponseDto(userEntity);
            favoriteList.add(favoriteItem);
        }

        return favoriteList;
    }
}
