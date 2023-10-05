package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReviewBoardEntity;
import com.team.back.entity.resultSet.ReviewBoardListResultSet;

@Repository
public interface ReviewBoardRepository extends JpaRepository<ReviewBoardEntity, Integer> {
    boolean existsByBoardNumber(Integer boardNumber);

    ReviewBoardEntity findByBoardNumber(Integer boardNumber);

    @Query(
        value = 
        "SELECT " +
        "RB.board_number AS boardNumber, " +
        "RB.title AS title, " +
        "RB.contents AS contents, " + 
        "RB.image_url AS iamgeUrl, " +
        "RB.view_count AS viewCount, " +
        "RB.comment_count AS commentCount, " +
        "RB.favorite_count AS favoriteCount, " +
        "RB.write_datetime AS writeDatetime, " +
        "RB.location AS location, " +
        "RB.business_type AS businessType, " +
        "U.nickname AS writerNickname " +
        "FROM review_board AS RB " +
        "INNER JOIN user AS U " +
        "ON RB.writer_email = U.email " +
        "ORDER BY RB.write_datetime DESC " +
        "LIMIT ?1, 30",
        nativeQuery=true
    )
    
    List<ReviewBoardListResultSet> getReviewBoardList(Integer section);

     @Query(
        value =
        "SELECT " +
        "RB.board_number AS boardNumber, " +
        "RB.title, " +
        "RB.contents, " +
        "RB.image_url AS ImageUrl, " +
        "RB.view_count AS viewCount, " +
        "RB.comment_count AS commentCount, " +
        "RB.favorite_count AS favoriteCount, " +
        "RB.write_datetime AS writeDatetime, " +
        "RB.location, " +
        "RB.business_type AS businessType, " +
        "U.nickname AS writerNickName " +
        "FROM review_board AS RB "+
        "INNER JOIN user AS U " +
        "ON RB.writer_email = U.email ",
        nativeQuery=true
    )
    List<ReviewBoardListResultSet> getReviewBoardList();
  
}
