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
@Entity(name="reservation")
@Table(name="reservation")
public class ReservationEntity {
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int reservationNumber;
  private String date;
  private String reservationDate;
  private int people;
  private int accompanyInfant;
  private int boardNumber;
  private String userEmail;

}
