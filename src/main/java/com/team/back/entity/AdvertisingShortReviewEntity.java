package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;

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
  @GeneratedValue
  private int commentNumber;
  private int boardNumber;
  private String userEmail;
  private String contents;
  private String wirteDatetime;

  public AdvertisingShortReviewEntity(Integer boardNumber, String useremail, PostAdvertisingRequestDto dto ){
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.boardNumber = boardNumber;
    this.userEmail = useremail;
    this.contents = dto.getContents();
    this.wirteDatetime = writeDatetime;


  }
  
}
