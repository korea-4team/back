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
  List<AdvertisingViewEntity> findByTitleContainsOrContentsContainsOrLocationContainsOrBusinessTypeContainsOrderByWriteDatetimeDesc(String title, String contents, String location, String businessType);
  List<AdvertisingViewEntity> findByTitleContainsOrContentsContainsOrBusinessTypeContainsOrderByWriteDatetimeDesc(String title, String contents, String businessType);
  
  @Query(
    value=
    "SELECT * " +
    "FROM advertising_board_view " + 
    "WHERE location LIKE %?1% " +
    "ORDER BY write_datetime DESC ",
    nativeQuery=true
  )
  List<AdvertisingViewEntity> getLocation(String location);

  @Query(
    value=
    "SELECT * " +
    "FROM advertising_board_view " + 
    "WHERE business_type LIKE %?1% " +
    "ORDER BY write_datetime DESC ",
    nativeQuery=true
  )
  List<AdvertisingViewEntity> getBusinessType(String businessType);
}
