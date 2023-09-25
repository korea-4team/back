package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.NoticeBoardEntity;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity, Integer> {
	
}
