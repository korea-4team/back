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
@Entity(name="business_number")
@Table(name="business_number")
public class BusinessNumberEntity {
    
    @Id
    private String storeNumber;
    private String storeName;
    private String address;
    private String addressDetail;
    private String businessType;
    private String ownerName;
    private String userEmail;
    // ! not null 로 지정하면 안됨 null 이 들어올 수 있어야 함
    private int boardNumber;

}
