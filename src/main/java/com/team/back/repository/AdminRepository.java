package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String>{
	boolean existsByAdminId(String adminId);
}
