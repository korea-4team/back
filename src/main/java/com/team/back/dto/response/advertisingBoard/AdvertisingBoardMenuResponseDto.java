package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingBoardMenuImageEntity;
import com.team.back.entity.AdvertisingMenuEntity;
import com.team.back.entity.resultSet.MenuListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisingBoardMenuResponseDto {

  private int menuNumber;
  private int boardNumber;
  private String title;
  private String contents;
  private List<String> imageUrls;
  private String price;

  public AdvertisingBoardMenuResponseDto(MenuListResultSet resultSet, List<AdvertisingBoardMenuImageEntity> imageEntities){

    List<String> imageUrls = new ArrayList<>();
    for (AdvertisingBoardMenuImageEntity entity: imageEntities) {
      String imageUrl = entity.getImageUrl();
      imageUrls.add(imageUrl);
    }

    this.menuNumber = resultSet.getMenuNumber();
    this.boardNumber = resultSet.getBoardNumber();
    this.contents = resultSet.getContents();
    this.imageUrls = imageUrls;
    this.title = resultSet.getTitle();
    this.price = resultSet.getPrice();

  }

  public AdvertisingBoardMenuResponseDto (AdvertisingMenuEntity advertisingMenuEntity, List<AdvertisingBoardMenuImageEntity> imageEntities){

    List<String> imageUrls = new ArrayList<>();
    for (AdvertisingBoardMenuImageEntity entity: imageEntities) {
      String imageUrl = entity.getImageUrl();
      imageUrls.add(imageUrl);
    }

    this.menuNumber = advertisingMenuEntity.getMenuNumber();
    this.boardNumber = advertisingMenuEntity.getBoardNumber();
    this.contents = advertisingMenuEntity.getContents();
    this.imageUrls = imageUrls;
    this.title = advertisingMenuEntity.getTitle();
    this.price = advertisingMenuEntity.getPrice();
  }
  
}
