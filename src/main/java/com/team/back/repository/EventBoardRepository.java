package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EventBoardEntity;
import com.team.back.entity.resultSet.EventBoardListResultSet;

@Repository
public interface EventBoardRepository extends JpaRepository<EventBoardEntity, Integer> {
    
    boolean existsByBoardNumber(Integer boardNumber);

    EventBoardEntity findByBoardNumber(Integer boardNumber);

    @Query(
        value =
            "SELECT " +
            "E.board_number AS boardNumber, " +
            "E.title AS title, "+
            "E.contents AS contents, " +
            "E.image_url AS imageUrl, " +
            "E.write_datetime AS writeDatetime, " +
            "A.admin_id AS adminId, " +
            "A.admin_nickname AS adminNickname " +
            "FROM event_board AS E " +
            "INNER JOIN admin AS A " +
            "ON E.writer_email = A.admin_id " +
            "ORDER BY E.write_datetime DESC " +
            "LIMIT ?1, 30",
        nativeQuery = true
    )
    List<EventBoardListResultSet> getEventBoardList(Integer section);
}
