package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PostShortReviewRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="short_review")
@Table(name="short_review")
public class AdvertisingShortReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int shortReviewNumber;
  private int boardNumber;
  private String userEmail;
  private String contents;
  private String writeDatetime;
  private double score;

  public AdvertisingShortReviewEntity(Integer boardNumber, String userEmail, PostShortReviewRequestDto dto){
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.boardNumber = boardNumber;
    this.userEmail = userEmail;
    this.contents = dto.getContents();
    this.writeDatetime = writeDatetime;
    this.score = dto.getScore();
  }

  
}
