package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
