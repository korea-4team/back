package com.team.back.dto.response.myPage;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.UserReservationListResultSet;

import lombok.Getter;

@Getter
public class UserReservationDto {
    private int reservationNumber;
    private String date;
    private String reserviationDate;
    private int people;
    private boolean accompanyInfant;
    private int boardNumber;
    private String title;
    private String contents;
    private String imageUrl;

    private UserReservationDto (UserReservationListResultSet resultSet) {
        this.reservationNumber = resultSet.getReservationNumber();
        this.date = resultSet.getDate();
        this.reserviationDate = resultSet.getReservationDate();
        this.people = resultSet.getPeople();
        this.accompanyInfant = resultSet.getAccompanyInfant() == 1;
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.contents = resultSet.getContents();
        this.imageUrl = resultSet.getImageUrl();
    }

    public static List<UserReservationDto> copyList(List<UserReservationListResultSet> resultSets) {
        List<UserReservationDto> list = new ArrayList<>();
        for (UserReservationListResultSet resultSet: resultSets) {
            UserReservationDto dto = new UserReservationDto(resultSet);
            list.add(dto);
        }
        return list;
    }
}
