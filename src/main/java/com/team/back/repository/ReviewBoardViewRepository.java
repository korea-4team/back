package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReviewBoardViewEntity;

@Repository
public interface ReviewBoardViewRepository extends JpaRepository<ReviewBoardViewEntity, Integer> {
    ReviewBoardViewEntity findByBoardNumber(Integer boardNumber);

    List<ReviewBoardViewEntity> findByTitleContainsOrContentsContainsOrderByWriteDatetimeDesc(String title, String contents);
    List<ReviewBoardViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String wirterEmail);
  
}
