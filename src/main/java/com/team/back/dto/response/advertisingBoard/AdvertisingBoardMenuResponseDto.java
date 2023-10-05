package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.AdvertisingMenuEntity;
import com.team.back.entity.resultSet.MenuListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisingBoardMenuResponseDto {

  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private String price;

  public AdvertisingBoardMenuResponseDto(MenuListResultSet resultSet){
    this.boardNumber = resultSet.getBoardNumber();
    this.contents = resultSet.getContents();
    this.imageUrl = resultSet.getImageUrl();
    this.title = resultSet.getTitle();
    this.price = resultSet.getPrice();

  }

  public AdvertisingBoardMenuResponseDto (AdvertisingMenuEntity advertisingMenuEntity){
    this.boardNumber = advertisingMenuEntity.getBoardNumber();
    this.contents = advertisingMenuEntity.getContents();
    this.imageUrl = advertisingMenuEntity.getImageUrl();
    this.title = advertisingMenuEntity.getTitle();
    this.price = advertisingMenuEntity.getPrice();
  }
  
  public static List<AdvertisingBoardMenuResponseDto> copyEntityList(List<AdvertisingMenuEntity> advertisingMenuEntities){
    List<AdvertisingBoardMenuResponseDto> menuList = new ArrayList<>();

    for (AdvertisingMenuEntity entity: advertisingMenuEntities){
      AdvertisingBoardMenuResponseDto menu = new AdvertisingBoardMenuResponseDto(entity);
      menuList.add(menu);
    }
    return menuList;
  }
}
