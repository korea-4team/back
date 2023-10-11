package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingMenuRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="advertising_board_menu")
@Table(name = "advertising_board_menu")
public class AdvertisingMenuEntity {

  @Id
  private int menuNumber;
  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private String price;

  public AdvertisingMenuEntity(int boardNumber, PostAdvertisingMenuRequestDto dto) {
    this.menuNumber = dto.getMenuNumber();
    this.boardNumber = boardNumber;
    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.imageUrl = dto.getImageUrl();
    this.price = dto.getPrice();
  }

  
}
