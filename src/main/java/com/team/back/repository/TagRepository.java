package com.team.back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, String> {
	
	List<TagEntity> findByBoardNumber(Integer boardNumber);

	@Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
