package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team.back.entity.AdvertisingShortReviewEntity;
import com.team.back.entity.resultSet.ShortReviewResultSet;
import com.team.back.entity.resultSet.UserShortReviewListResultSet;

@Repository
public interface ShortReviewAdvertisingBoardRepository extends JpaRepository<AdvertisingShortReviewEntity, Integer>{
  @Query(
  value =
  "SELECT " +
  "SR.board_number AS boardNumber, " +
  "U.nickname AS nickname, " +
  "SR.contents AS contents, " +
  "SR.write_datetime AS writeDatetime " +
  "FROM short_review AS SR INNER JOIN user AS U " +
  "ON SR.user_email = U.email " +
  "WHERE board_number = ?1 " +
  "ORDER BY SR.write_datetime",
  nativeQuery=true
  )
  List<ShortReviewResultSet> getShortReviewList(Integer boardNumber);
  
  @Transactional
  void deleteByBoardNumber(Integer boardNumber);

  @Query(
    value =
    "SELECT " +
    "S.board_number AS boardNumber, " +
    "S.contents, " +
    "S.write_datetime AS writeDatetime, "+
    "U.nickname AS writerNickname " +
    "FROM short_review AS S INNER JOIN user AS U " +
    "ON S.user_email = U.email",
    nativeQuery = true
  )
  List<ShortReviewResultSet> getShortReviewList();

  @Query(
    value=
    "SELECT " +
      "S.board_number AS shortReviewNumber, " +
      "S.write_datetime AS writeDatetime, " + 
      "S.contents AS contents, " +
      "S.image_url AS imageUrl, " +
      "S.score AS score, " +
      "A.board_number AS boardNumber, " +
      "A.title AS boardTitle, " +
      "A.contents AS boardContents, " + 
      "A.image_url AS boardImageUrl " +
    "FROM short_review S " + 
    "LEFT JOIN advertising_board A " +
    "ON S.board_number = A.board_number " +
    "WHERE S.user_email = ?1 " +
    "ORDER BY S.write_datetime DESC ",
    nativeQuery=true
  )
  List<UserShortReviewListResultSet> getUserShortReviewList(String email);

  

  List<AdvertisingShortReviewEntity> findByUserEmail(String userEmail);

}
