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
    "AB.board_number AS boardNumber, " +
    "AB.title AS title, " +
    "AB.contents AS contents, " + 
    "AB.image_url AS iamgeUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.comment_count AS commentCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "U.nickname AS writerNickname " +
    "FROM advertising_board_short_review AS AB " +
    "INNER JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?1, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(Integer section);

    @Query(
    value =
    "AB.board_number AS board_number, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS image_url, "+
    "AB.view_count AS view_count, "+
    "AB.short_review_count AS short_review_count, "+
    "AB.favorite_count AS favorite_count, "+
    "AB.write_datetime AS write_datetime, "+
    "AB.location AS location, "+
    "AB.business_type AS business_type, "+
    "U.email AS writer_email, "+
    "U.nickname AS writer_nickname, "+
    "T.tag_word AS tag_word "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "INNER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word " +
    "WHERE AB.title LIKE %?1% " +
    "OR AB.business_type LIKE %?1% " + 
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?2, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord, Integer section);

    @Query(
    value =
    "AB.board_number AS board_number, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS image_url, "+
    "AB.view_count AS view_count, "+
    "AB.short_review_count AS short_review_count, "+
    "AB.favorite_count AS favorite_count, "+
    "AB.write_datetime AS write_datetime, "+
    "AB.location AS location, "+
    "AB.business_type AS business_type, "+
    "U.email AS writer_email, "+
    "U.nickname AS writer_nickname, "+
    "T.tag_word AS tag_word "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "INNER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word " +
    "LIMIT ?3, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord, String location, Integer section);

  @Query(
    value =
    "AB.board_number AS board_number, "+
    "AB.title AS title, "+
    "AB.contents AS contents, "+
    "AB.image_url AS image_url, "+
    "AB.view_count AS view_count, "+
    "AB.short_review_count AS short_review_count, "+
    "AB.favorite_count AS favorite_count, "+
    "AB.write_datetime AS write_datetime, "+
    "AB.location AS location, "+
    "AB.business_type AS business_type, "+
    "U.email AS writer_email, "+
    "U.nickname AS writer_nickname, "+
    "T.tag_word AS tag_word "+
    "FROM advertising_board AS AB "+
    "INNER JOIN user AS U "+
    "ON AB.writer_email = U.email "+
    "INNER JOIN tag AS T "+
    "ON AB.tag_word = T.tag_word ",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList();

  List<AdvertisingBoardEntity> findByLocationOrderByWriteDatetimeDesc(String location);


}
