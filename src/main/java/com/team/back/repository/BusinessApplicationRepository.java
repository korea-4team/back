package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.BusinessApplicationEntity;

@Repository
public interface BusinessApplicationRepository extends JpaRepository<BusinessApplicationEntity, Integer> {
    
}
