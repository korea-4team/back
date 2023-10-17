package com.team.back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingMenuEntity;

@Repository
public interface AdvertisingMenuRepository extends JpaRepository<AdvertisingMenuEntity, Integer>{

	AdvertisingMenuEntity findByMenuNumber(Integer menuNumber);

	List<AdvertisingMenuEntity> findByBoardNumber(Integer boardNumber);
	
	@Transactional
    void deleteByBoardNumber(Integer boardNumber);
	
}
