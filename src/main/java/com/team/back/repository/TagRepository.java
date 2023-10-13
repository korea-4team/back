package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, String> {
	
}
