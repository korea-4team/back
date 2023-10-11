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
  boolean existsByWriterEmail(String writerEmail);
  
  AdvertisingBoardEntity findByBoardNumber(Integer boardNumber);
  
  @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, " +
    "AB.title AS title, " +
    "AB.contents AS contents, " +
    "AB.image_url AS iamgeUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.comment_count AS commentCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "U.nickname AS writerNickname " +
    "FROM advertising_board AS AB " +
    "INNER JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?1, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(Integer section);

    @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS imageUrl, "+
    "AB.view_count AS viewCount, "+
    "AB.short_review_count AS shortReviewCount, "+
    "AB.favorite_count AS favoriteCount, "+
    "AB.write_datetime AS writeDatetime, "+
    "AB.location AS location, "+
    "AB.business_type AS businessType, "+
    "U.email AS writerEmail, "+
    "U.nickname AS writerNickname, "+
    "T.tag_word AS tagWord "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "INNER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word " +
    "WHERE AB.title LIKE %?1% " +
    "OR AB.contents LIKE %?1% " +
    "OR AB.business_type LIKE %?1% " + 
    "OR T.tag_word LIKE %?1% " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?2, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord, Integer section);

    @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS imageUrl, "+
    "AB.view_count AS viewCount, "+
    "AB.short_review_count AS shortReviewCount, "+
    "AB.favorite_count AS favoriteCount, "+
    "AB.write_datetime AS writeDatetime, "+
    "AB.location AS location, "+
    "AB.business_type AS businessType, "+
    "U.email AS writerEmail, "+
    "U.nickname AS writerNickname, "+
    "T.tag_word AS tagWord "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "INNER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word " +
    "WHERE AB.title LIKE %?1% " +
    "OR AB.contents LIKE %?1% " +
    "OR AB.business_type LIKE %?1% " +
    "OR AB.location LIKE %?2% " +
    "OR T.tag_word LIKE %?1% " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?3, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord, String location, Integer section);

  @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS imageUrl, "+
    "AB.view_count AS viewCount, "+
    "AB.short_review_count AS shortReviewCount, "+
    "AB.favorite_count AS favoriteCount, "+
    "AB.write_datetime AS writeDatetime, "+
    "AB.location AS location, "+
    "AB.business_type AS businessType, "+
    "U.email AS writerEmail, "+
    "U.nickname AS writerNickname, "+
    "AB.tag_word AS tagWord "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "LEFT OUTER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word ",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList();

  List<AdvertisingBoardEntity> findByLocationOrderByWriteDatetimeDesc(String location);


}
