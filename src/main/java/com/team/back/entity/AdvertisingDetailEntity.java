package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PostAdvertisingDetailRequestDto;
import com.team.back.dto.request.advertisingBoard.PostAdvertisingMenuRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="advertising_board_detail")
@Table(name = "advertising_board_detail")
@ToString
public class AdvertisingDetailEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boardNumber;
    public String storeName;
    public String storeTel;
    public String storeTime;
    public String storeNumber;
    public String storeAddress;
    public AdvertisingDetailEntity(int boardNumber, PostAdvertisingDetailRequestDto dto) {
        this.boardNumber = boardNumber;
        this.storeName = dto.getStoreName();
        this.storeAddress = dto.getStoreAddress();
        this.storeTel = dto.getStoreTel();
        this.storeNumber = dto.getStoreNumber();
        this.storeTime = dto.getStoreTime();
    }

}
