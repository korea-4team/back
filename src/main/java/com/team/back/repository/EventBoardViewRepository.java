package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EventBoardViewEntity;

@Repository
public interface EventBoardViewRepository extends JpaRepository<EventBoardViewEntity, Integer> {
    EventBoardViewEntity findByBoardNumber(Integer boardNumber);
}
