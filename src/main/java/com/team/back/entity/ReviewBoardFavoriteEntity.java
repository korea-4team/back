package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.team.back.entity.pk.FavoritePk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="review_board_favorite")
@Table(name="review_board_favorite")
@IdClass(FavoritePk.class)
public class ReviewBoardFavoriteEntity {
  @Id
  private int boardNumber;
  @Id
  private String userEmail;
  
}
