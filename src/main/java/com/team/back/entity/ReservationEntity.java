package com.team.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class ReservationEntity implements Serializable {
  
  @Id
  private int boardNumber;
  @Id
  private String writerNickname;
  
  private int people;
  private String time;
}
