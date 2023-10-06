package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team.back.entity.AdvertisingShortReviewEntity;
import com.team.back.entity.resultSet.ShortReviewResultSet;

@Repository
public interface ShortReviewAdvertisingBoardRepository extends JpaRepository<AdvertisingShortReviewEntity, Integer>{
  @Query(
  value =
  "SELECT " +
  "U.nickname AS nickname, " +
  "RC.contents AS contents, " +
  "RC.write_datetime AS writeDatetime " +
  "FROM short_review_comment AS RC INNER JOIN user AS U " +
  "ON RC.user_email = U.email " +
  "WHERE board_number = ?1 " +
  "ORDER BY RC.write_datetime",
  nativeQuery=true
  )
  List<ShortReviewResultSet> getShortReviewList(Integer boardNumber);
  
  @Transactional
  void deleteByBoardNumber(Integer boardNumber);

  @Query(
    value =
    "SELECT " +
    "S.contents, " +
    "S.write_datetime, "+
    "U.nickname " +
    "FROM advertising_board_short_review AS S INNER JOIN user AS U " +
    "ON S.user_email = U.email",
    nativeQuery = true
  )
  List<ShortReviewResultSet> getShortReviewList();

  List<AdvertisingShortReviewEntity> findByUserEmail(String userEmail);

}
