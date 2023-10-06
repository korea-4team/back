package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.CommentViewEntity;

@Repository
public interface CommentViewRepository extends JpaRepository<CommentViewEntity, Integer> {
	List<CommentViewEntity> findByUserEmail(String userEmail);
}
