package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="advertising_board_menu_image")
@Table(name="advertising_board_menu_image")
public class AdvertisingBoardMenuImageEntity {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int sequence;
  private int menuNumber;
  private String imageUrl; 

  public AdvertisingBoardMenuImageEntity (int menuNumber, String imageUrl) {
    this.menuNumber = menuNumber;
    this.imageUrl = imageUrl;
  }
}

