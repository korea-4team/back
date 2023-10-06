package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingBoardEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;

@Repository
public interface AdvertisingBoardRepository extends JpaRepository<AdvertisingBoardEntity, Integer>{
  boolean existsByBoardNumber(Integer boardNumber);
  
  AdvertisingBoardEntity findByBoardNumber(Integer boardNumber);
  
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
    "U.nickname AS writerNickname " +
    "FROM advertising_board_short_review AS RB " +
    "INNER JOIN user AS U " +
    "ON RB.writer_email = U.email " +
    "ORDER BY RB.write_datetime DESC " +
    "LIMIT ?1, 50",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(Integer section);

  @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, " +
    "AB.title, " +
    "AB.contents, " +
    "AB.image_url AS imageUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.short_review_count AS shortReviewCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "AB.writer_email AS writerEmail, " +
    "U.nickname AS writerNickname " +
    "FROM advertising_board AS AB " +
    "INNER JOIN user AS U " +
    "ON AB.writer_email = U.email",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList();


}
