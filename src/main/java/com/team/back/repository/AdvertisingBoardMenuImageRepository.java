package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingBoardMenuImageEntity;

@Repository
public interface AdvertisingBoardMenuImageRepository extends JpaRepository<AdvertisingBoardMenuImageEntity, Integer> {
  List<AdvertisingBoardMenuImageEntity> findByMenuNumber(Integer menuNumber);
}
