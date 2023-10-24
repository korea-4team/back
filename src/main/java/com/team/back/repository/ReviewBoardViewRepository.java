package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReviewBoardViewEntity;

@Repository
public interface ReviewBoardViewRepository extends JpaRepository<ReviewBoardViewEntity, Integer> {
    ReviewBoardViewEntity findByBoardNumber(Integer boardNumber);

    List<ReviewBoardViewEntity> findByTitleContainsOrContentsContainsOrBusinessTypeContainsOrderByWriteDatetimeDesc(String title, String contents, String businessType);
    @Query(
        value = 
        "SELECT * " +
        "FROM review_board_view " +
        "WHERE (title LIKE %?1% OR contents LIKE %?2% OR business_type LIKE %?3%) " +
        "AND location LIKE %?4% " +
        "ORDER BY write_datetime DESC",
        nativeQuery=true
    )
    List<ReviewBoardViewEntity> getWithLocationSearch(String title, String contents, String businessType, String location);
    List<ReviewBoardViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String wirterEmail);
    List<ReviewBoardViewEntity> findByLocationOrderByWriteDatetimeDesc(String location);
    List<ReviewBoardViewEntity> findByBusinessTypeOrderByWriteDatetimeDesc(String businessType);
    List<ReviewBoardViewEntity> findByLocationAndBusinessTypeOrderByWriteDatetimeDesc(String location, String businessType);
    List<ReviewBoardViewEntity> findByWriterEmail(String writerEmail);
  
}
