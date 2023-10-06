package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PatchAdvertisingRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="advertising_board")
@Table(name = "advertising_board")
public class AdvertisingBoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int boardNumber;
  private String title;
  private String contents;
  private String image_Url;
  private int view_Count;
  private int short_review_count;
  private int favorite_Count;
  private String write_datetime;
  private String writer_email;
  private String location;
  private String businessType;


  public AdvertisingBoardEntity(String writerEmail, PostAdvertisingRequestDto dto){
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.image_Url = dto.getImageUrl();
    this.write_datetime = writeDatetime;
    this.writer_email = writerEmail;
    this.location = dto.getLocation();
    this.businessType = dto.getBusinessType();
  }

  public void patch(PatchAdvertisingRequestDto dto){
    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.image_Url = dto.getImageUrl();
  }

  public void increaseViewCount() {
    this.view_Count++;
  }

  public void increaseCommentCount() {
    this.short_review_count++;
  }

  public void increaseFavoriteCount() {
    this.favorite_Count++;
  }
  
  public void decreaseFavoriteCount() {
    this.favorite_Count--;
  }
  
}
