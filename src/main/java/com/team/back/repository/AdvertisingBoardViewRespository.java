package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingViewEntity;


@Repository
public interface AdvertisingBoardViewRespository extends JpaRepository<AdvertisingViewEntity, Integer>{

  AdvertisingViewEntity findByBoardNumber(Integer boardNumber);
  List<AdvertisingViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);
  List<AdvertisingViewEntity> findByLocationOrderByWriteDatetimeDesc(String location);
  List<AdvertisingViewEntity> findByBusinessTypeOrderByWriteDatetimeDesc(String businessType);
  List<AdvertisingViewEntity> findByLocationOrBusinessTypeOrderByWriteDatetimeDesc(String location, String businessType);
 
  List<AdvertisingViewEntity> findByWriterEmail(String writerEmail);
  List<AdvertisingViewEntity> findByTitleContainsOrContentsContainsOrBusinessTypeContainsOrTagWordContainsOrderByWriteDatetimeDesc(String title, String contents, String businessType, String tagWord);

      @Query(
        value = 
        "SELECT * " +
        "FROM advertising_board_view " +
        "WHERE (title LIKE %?1% OR contents LIKE %?2% OR business_type LIKE %?3% OR tag_word LIKE %?4%) " +
        "AND location LIKE %?5% " +
        "ORDER BY write_datetime DESC",
        nativeQuery=true
    )
  List<AdvertisingViewEntity> getWithLocationSearch(String title, String contents, String businessType, String tagWord, String location);
  
}
