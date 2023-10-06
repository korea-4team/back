package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.ReservationEntity;
import com.team.back.entity.resultSet.ReservationResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationResponseDto {

  private int boardNumber;
  private String time;
  private String writerNickname;
  private int people;

  public ReservationResponseDto (ReservationResultSet resultSet){
    this.boardNumber = resultSet.getBoardNumber();
    this.writerNickname = resultSet.getWriterNickname();
    this.time = resultSet.getTime();
    this.people = resultSet.getpeople();
  }


  // public ReservationResponseDto (ReservationEntity reservationEntity){
  //   this.boardNumber = reservationEntity.getBoardNumber();
  //   this.writerNickname = reservationEntity.getWriterNickname();
  //   this.time = reservationEntity.getTime();
  //   this.people = reservationEntity.getPeople();
  // }
  
  public static List<ReservationResponseDto> copyList(List<ReservationResultSet> resultSets){
    List<ReservationResponseDto> reservationList = new ArrayList<>();

    for (ReservationResultSet resultSet: resultSets){
      ReservationResponseDto reservation = new ReservationResponseDto(resultSet);
      reservationList.add(reservation);
    }
    return reservationList;
  }

  // public static List<ReservationResponseDto> copyEntityList(List<ReservationEntity> reservationEntities){
  //   List<ReservationResponseDto> reservationList = new ArrayList<>();

  //   for (ReservationEntity entity: reservationEntities){
  //     ReservationResponseDto reservation = new ReservationResponseDto(entity);
  //     reservationList.add(reservation);
  //   }
  //   return reservationList;
  // }
  
}
