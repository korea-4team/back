package com.team.back.dto.response.myPage;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.MyReservationResultSet;

import lombok.Getter;

@Getter
public class ReservationListResponseDto {
    
    private int boardNumber;
    private String title;
    private int reservationNumber;
    private String date;
    private String reservationDate;
    private int people;
    private boolean accompanyInfant;

    public ReservationListResponseDto (MyReservationResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.reservationNumber = resultSet.getReservationNumber();
        this.date = resultSet.getDate();
        this.reservationDate = resultSet.getReservationDate();
        this.people = resultSet.getPeople();
        this.accompanyInfant = resultSet.getAccompanyInfant() == 0 ? false : true;
    }

    public static List<ReservationListResponseDto> copyList(List<MyReservationResultSet> resultSets) {
        List<ReservationListResponseDto> list = new ArrayList<>();
        for (MyReservationResultSet resultSet: resultSets) {
            ReservationListResponseDto dto = new ReservationListResponseDto(resultSet);
            list.add(dto);
        }
        return list;
    }

}
