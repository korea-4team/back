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
  private int short_review_count;
  private int favorite;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private String location;
  private String businessType;
  private String tag;
  
  
}
