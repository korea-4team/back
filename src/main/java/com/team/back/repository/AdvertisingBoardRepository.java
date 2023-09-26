package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team.back.entity.AdvertisingViewEntity;
import com.team.back.entity.resultSet.AdvertisingBoardResultSet;

@Repository
public interface AdvertisingBoardRepository extends JpaRepository<AdvertisingViewEntity, Integer>{
  @Query(
  value =



  
    "SELECT" + 
      "U.nickname AS nickname," +
      "C.contents AS contents," +
      "C.write_datetime AS writeDatetime" +
    "From ShortReview AS C INNER JOIN user AS U" +
    "ON C.user_email = U.email" +
    "WHERE board_number = ?1" +
    "ORDER BY C.write_datetime",
    nativeQuery=true
  )
  List<AdvertisingBoardResultSet> ShortReviewList(Integer boardNumber);
  

  @Transactional
  void deleteAdvertisingBoard(Integer boardNumber);
    

}
