package com.team.back.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.FavoriteEntity;
import com.team.back.entity.pk.FavoritePk;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
  
  boolean existsByUserEmailAndBoardNumber(String userEmail, Integer boardNumber);

  @Transactional
  void deleteByBoardNumber(Integer boardNumber);
}
