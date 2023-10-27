package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingBoardImageEntity;

@Repository
public interface AdvertisingBoardImageRepository extends JpaRepository<AdvertisingBoardImageEntity, Integer> {
  List<AdvertisingBoardImageEntity> findByBoardNumber(Integer boardNumber);
}
