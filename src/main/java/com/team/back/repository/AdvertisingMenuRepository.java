package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdvertisingMenuEntity;

@Repository
public interface AdvertisingMenuRepository extends JpaRepository<AdvertisingMenuEntity, Integer>{

	AdvertisingMenuEntity findByMenuNumber(Integer menuNumber);
	
}
