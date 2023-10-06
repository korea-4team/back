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
@Entity(name="advertising_board_short_review")
@Table(name="advertising_board_short_review")
public class AdvertisingShortReviewEntity {

  @Id
  private int shortReviewNumber;
  private int boardNumber;
  private String userEmail;
  private String contents;
  private String writeDatetime;
  private double score;

  
}
