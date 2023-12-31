package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.reviewBoard.PatchReviewBoardRequestDto;
import com.team.back.dto.request.reviewBoard.PostReviewBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="review_board")
@Table(name="review_board")
public class ReviewBoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private int viewCount;
  private int commentCount;
  private int favoriteCount;
  private String writeDatetime;
  private String writerEmail;
  private String location;
  private String businessType;

  public ReviewBoardEntity(String writerEmail, PostReviewBoardRequestDto dto) {
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.imageUrl = dto.getImageUrl();
    this.writeDatetime = writeDatetime;
    this.writerEmail = writerEmail;
    this.location = dto.getLocation();
    this.businessType = dto.getBusinessType();
  }

  public void patch(PatchReviewBoardRequestDto dto) {
    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.imageUrl = dto.getImageUrl();
    this.location = dto.getLocation();
    this.businessType = dto.getBusinessType();
  }

  public void increaseViewCount() {
    this.viewCount++;
  }

  public void increaseCommentCount() {
    this.commentCount++;
  }

  public void decreaseCommentCount() {
    this.commentCount--;
  }

  public void increaseFavoriteCount() {
    this.favoriteCount++;
  }
  
  public void decreaseFavoriteCount() {
    this.favoriteCount--;
  }
  
}
