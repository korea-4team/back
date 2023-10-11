package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReservationEntity;
import com.team.back.entity.resultSet.MyReservationResultSet;
import com.team.back.entity.resultSet.UserReservationListResultSet;
import com.team.back.entity.resultSet.UserStoreReservationListResultSet;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    
    @Query(
        value=
        "SELECT " +
            "A.board_number AS boardNumber, " +
            "A.title AS title, " +
            "R.reservation_number AS reservationNumber, " +
            "R.date AS date, " + 
            "R.reservation_date AS reservationDate, " +
            "R.people AS people, " +
            "R.accompany_infant AS accompanyInfant " +
        "FROM reservation R " +
        "LEFT JOIN advertising_board A " +
        "ON R.board_number = A.board_number " +
        "WHERE R.user_email = ?1 ",
        nativeQuery=true
    )
    List<MyReservationResultSet> getMyReservationList(String email);

    @Query(
        value=
        "SELECT " + 
            "R.reservation_number AS reservationNumber, " +
            "R.date AS date, " + 
            "R.reservation_date AS reservationDate, " +
            "R.people AS people, " +
            "R.accompany_infant AS accompanyInfant, " +
            "A.board_number AS boardNumber, " +
            "A.title AS title, " +
            "A.contents AS contents, " +
            "A.image_url AS imageUrl " +
        "FROM reservation R " +
        "LEFT JOIN advertising_board A " +
        "ON R.board_number = A.board_number " +
        "WHERE R.user_email = ?1 " +
        "ORDER BY R.reservation_date DESC ",
        nativeQuery=true
    )
    List<UserReservationListResultSet> getUserReservationList(String email);

    @Query(
        value=
        "SELECT " +
            "R.reservation_number AS reservationNumber, " +
            "R.date AS date, " +
            "R.reservation_date AS reservationDate, " +
            "R.people AS people, " +
            "R.accompany_infant AS accompanyInfant, " +
            "U.email as email, " +
            "U.nickname as nickname " +
        "FROM reservation R " +
        "LEFT JOIN user U " +
        "ON R.user_email = U.email " +
        "WHERE R.board_number = ( " +
            "SELECT board_number  " +
            "FROM advertising_board A " +
            "WHERE A.writer_email = ?1 " +
        ") ",
        nativeQuery=true
    )
    List<UserStoreReservationListResultSet> getUserStoreReservationList(String email);
}
