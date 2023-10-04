package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.UserViewEntity;

@Repository
public interface UserViewRepository extends JpaRepository<UserViewEntity, String> {
	
	UserViewEntity findByUserEmail(String userEmail);

}
