package com.team.back.dto.response.myPage;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.UserStoreReservationListResultSet;

import lombok.Getter;

@Getter
public class UserStoreReservationDto {
    private int reservationNumber;
    private String date;
    private String reservationDate;
    private int people;
    private boolean accompanyInfant;
    private String email;
    private String nickname;

    private UserStoreReservationDto (UserStoreReservationListResultSet resultSet) {
        this.reservationNumber = resultSet.getReservateNumber();
        this.date = resultSet.getDate();
        this.reservationDate = resultSet.getReservationDate();
        this.people = resultSet.getPeople();
        this.accompanyInfant = resultSet.getAccompanyInfant() == 1;
        this.email = resultSet.getEmail();
        this.nickname = resultSet.getNickname();
    }

    public static List<UserStoreReservationDto> copyList(List<UserStoreReservationListResultSet> resultSets) {
        List<UserStoreReservationDto> list = new ArrayList<>();
        for (UserStoreReservationListResultSet resultSet: resultSets) {
            UserStoreReservationDto dto = new UserStoreReservationDto(resultSet);
            list.add(dto);
        }
        return list;
    }
}
