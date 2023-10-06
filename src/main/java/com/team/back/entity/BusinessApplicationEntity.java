package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.myPage.RegistrationRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="business_application")
@Table(name="business_application")
public class BusinessApplicationEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private String userEmail;
    private String storeNumber;
    private String storeName;
    private String address;
    private String addressDetail;
    private String businessType;
    private String storeStartHours;
    private String storeFinishHours;
    private String storeTelNumber;

    public BusinessApplicationEntity(RegistrationRequestDto dto, String email) {
        this.userEmail = email;
        this.storeNumber = dto.getStoreNumber();
        this.storeName = dto.getStoreName();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.businessType = dto.getBusinessType();
        this.storeStartHours = dto.getStoreStartHours();
        this.storeFinishHours = dto.getStoreFinishHours();
        this.storeTelNumber = dto.getStoreTelNumber();
    }
}
