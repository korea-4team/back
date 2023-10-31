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
  private int viewCount;
  private int shortReviewCount;
  private int favoriteCount;
  private String writeDatetime;
  private String writerEmail;
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



  public AdvertisingBoardEntity(String writerEmail, PostAdvertisingRequestDto dto){
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.title = dto.getTitle();
    this.contents = dto.getContents();
    this.writeDatetime = writeDatetime;
    this.writerEmail = writerEmail;
    this.location = dto.getLocation();
    this.businessType = dto.getBusinessType();

    this. storeName = dto.getStoreName();
    this.storeTel = dto.getStoreTel();
    this.storeTime = dto.getStoreTime();
    this.storeNumber = dto.getStoreNumber();
    this.storeAddress = dto.getStoreAddress();

    this.bookTime = dto.getBookTime();
    this.book = dto.getBook();
    this.bookKids = dto.getBookKids();

  }



  public void patch(PatchAdvertisingRequestDto dto){
    this.title = dto.getTitle();
    this.contents = dto.getContents();
  }

  public void increaseViewCount() {
    this.viewCount++;
  }

  public void increaseCommentCount() {
    this.shortReviewCount++;
  }

  public void increaseFavoriteCount() {
    this.favoriteCount++;
  }
  
  public void decreaseFavoriteCount() {
    this.favoriteCount--;
  }


  
  
}
