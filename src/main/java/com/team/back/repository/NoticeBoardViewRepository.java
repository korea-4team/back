package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.NoticeBoardEntity;
import com.team.back.entity.NoticeBoardViewEntity;

@Repository
public interface NoticeBoardViewRepository extends JpaRepository<NoticeBoardEntity, Integer> {
	NoticeBoardViewEntity findByBoardNumber(Integer boardNumber);
}
