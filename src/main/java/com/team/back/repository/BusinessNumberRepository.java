package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.BusinessNumberEntity;

public interface BusinessNumberRepository extends JpaRepository<BusinessNumberEntity, String> {
    boolean existsByStoreNumber(String storeNumber);
}
