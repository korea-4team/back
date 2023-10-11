package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReviewBoardViewEntity;

@Repository
public interface ReviewBoardViewRepository extends JpaRepository<ReviewBoardViewEntity, Integer> {
    ReviewBoardViewEntity findByBoardNumber(Integer boardNumber);

    List<ReviewBoardViewEntity> findByTitleContainsOrContentsContainsOrBusinessTypeOrderByWriteDatetimeDesc(String title, String contents, String businessType);
    List<ReviewBoardViewEntity> findByTitleContainsOrContentsContainsOrLocationOrBusinessTypeOrderByWriteDatetimeDesc(String title, String contents, String location, String businessType);
    List<ReviewBoardViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String wirterEmail);
    List<ReviewBoardViewEntity> findByLocationOrderByWriteDatetimeDesc(String location);
    List<ReviewBoardViewEntity> findByBusinessTypeOrderByWriteDatetimeDesc(String businessType);
    List<ReviewBoardViewEntity> findByLocationAndBusinessTypeOrderByWriteDatetimeDesc(String location, String businessType);
    List<ReviewBoardViewEntity> findByWriterEmail(String writerEmail);
  
}
