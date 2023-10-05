package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingViewEntity;


@Repository
public interface AdvertisingBoardViewRespository extends JpaRepository<AdvertisingViewEntity, Integer>{

  AdvertisingViewEntity findByBoardNumber(Integer boardNumber);

  List<AdvertisingViewEntity> findByTitleContainsOrContentsContainsOrderByWriteDatetimeDesc(String title, String Contents);
  List<AdvertisingViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);
  List<AdvertisingViewEntity> findByLocationOrderByWriteDatetimeDesc(String location);
  List<AdvertisingViewEntity> findByBusinessTypeOrderByWriteDatetimeDesc(String businessType);
  List<AdvertisingViewEntity> findByLocationOrBusinessTypeOrderByWriteDatetimeDesc(String location, String businessType);
  
}
