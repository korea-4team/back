package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="advertising_board_view")
@Table(name="advertising_board_view")
public class AdvertisingViewEntity {

  @Id
  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private int viewCount;
  private int shortReviewCount;
  private int favoriteCount;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private String location;
  private String businessType;
  private String storeName;
  private String storeTel;
  private String storeTime;
  private String storeNumber;
  private String storeAddress;
  private String bookTime;
  private String book;
  private String bookKids;
  
}
