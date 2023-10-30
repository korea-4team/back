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
    "I.board_title_image AS imageUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.short_review_count AS shortReviewCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "AB.location AS location, " +
    "AB.business_type AS businessType, " +
    "U.email AS writerEmail, " +
    "U.nickname AS writerNickname, " +
    "T.tag_word AS tagWord " +
    "FROM advertising_board AS AB " +
    "LEFT JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "LEFT JOIN ( " +
            "SELECT board_number, ANY_VALUE(image_url) AS board_title_image " +
            "FROM advertising_board_image " +
            "GROUP BY board_number " +
        ") AS I " +
        "ON ab.board_number = I.board_number " +
    "LEFT JOIN tag AS T " +
    "ON AB.board_number = T.board_number " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?1, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(Integer section);

    @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, " +
    "AB.title AS title, " +
    "AB.contents AS contents, " +
    "I.board_title_image AS imageUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.short_review_count AS shortReviewCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "AB.location AS location, " +
    "AB.business_type AS businessType, " +
    "U.email AS writerEmail, " +
    "U.nickname AS writerNickname, " +
    "T.tag_word AS tagWord " +
    "FROM advertising_board AS AB " +
    "LEFT JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "LEFT JOIN ( " +
            "SELECT board_number, ANY_VALUE(image_url) AS board_title_image " +
            "FROM advertising_board_image " +
            "GROUP BY board_number " +
        ") AS I " +
        "ON ab.board_number = I.board_number " +
    "LEFT JOIN tag AS T " +
    "ON AB.board_number = T.board_number " +
    "WHERE AB.title LIKE %?1% " +
    "OR AB.contents LIKE %?1% " +
    "OR AB.business_type LIKE %?1% " + 
    "OR T.tag_word LIKE %?1% " +
    "ORDER BY AB.write_datetime DESC ",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord);

    @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, " +
    "AB.title AS title, " +
    "AB.contents AS contents, " +
    "I.board_title_image AS imageUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.short_review_count AS shortReviewCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "AB.location AS location, " +
    "AB.business_type AS businessType, " +
    "U.email AS writerEmail, " +
    "U.nickname AS writerNickname, " +
    "T.tag_word AS tagWord " +
    "FROM advertising_board AS AB " +
    "LEFT JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "LEFT JOIN ( " +
            "SELECT board_number, ANY_VALUE(image_url) AS board_title_image " +
            "FROM advertising_board_image " +
            "GROUP BY board_number " +
        ") AS I " +
        "ON ab.board_number = I.board_number " +
    "LEFT JOIN tag AS T " +
    "ON AB.board_number = T.board_number " +
    "WHERE (AB.title LIKE %?1% " +
    "OR AB.contents LIKE %?1% " +
    "OR AB.business_type LIKE %?1% " +
    "OR T.tag_word LIKE %?1%) " +
    "AND AB.location LIKE %?2% " +
    "ORDER BY AB.write_datetime DESC ",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdvertisingBoardList(String searchWord, String location);

  List<AdvertisingBoardEntity> findByLocationOrderByWriteDatetimeDesc(String location);

    @Query(
    value =
    "SELECT " +
    "AB.board_number AS boardNumber, " +
    "AB.title AS title, " +
    "AB.contents AS contents, " +
    "I.board_title_image AS imageUrl, " +
    "AB.view_count AS viewCount, " +
    "AB.short_review_count AS shortReviewCount, " +
    "AB.favorite_count AS favoriteCount, " +
    "AB.write_datetime AS writeDatetime, " +
    "AB.location AS location, " +
    "AB.business_type AS businessType, " +
    "U.email AS writerEmail, " +
    "U.nickname AS writerNickname, " +
    "T.tag_word AS tagWord " +
    "FROM advertising_board AS AB " +
    "LEFT JOIN user AS U " +
    "ON AB.writer_email = U.email " +
    "LEFT JOIN ( " +
            "SELECT board_number, ANY_VALUE(image_url) AS board_title_image " +
            "FROM advertising_board_image " +
            "GROUP BY board_number " +
        ") AS I " +
        "ON ab.board_number = I.board_number " +
    "LEFT JOIN tag AS T " +
    "ON AB.board_number = T.board_number " +
    "ORDER BY AB.write_datetime DESC " +
    "LIMIT ?1, 30",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> getAdminAdvertisingBoardList(Integer section);

}
