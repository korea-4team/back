package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class AdvertisingShortReviewEntity {

  @Id
  @GeneratedValue
  private int commentNumber;
  private int BoardNumber;
  private String userEmail;
  private String contents;
  private String wirteDatetime;

  public AdvertisingShortReviewEntity(Integer boardNumber, String useremail, PostAdvertisingRequestDto dto ){
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.BoardNumber = boardNumber;
    this.userEmail = useremail;
    this.contents = dto.getContents();
    this.wirteDatetime = writeDatetime;


  }
  
}
