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
@Entity(name="advertising_board_image")
@Table(name="advertising_board_image")
public class AdvertisingBoardImageEntity {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int sequence;
  private int boardNumber;
  private String imageUrl; 

  public AdvertisingBoardImageEntity(int boardNumber, String imageUrl) {
    this.boardNumber = boardNumber;
    this.imageUrl = imageUrl;
  }
}
