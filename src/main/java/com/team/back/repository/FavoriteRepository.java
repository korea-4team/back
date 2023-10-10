package com.team.back.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.ReviewBoardFavoriteEntity;
import com.team.back.entity.pk.FavoritePk;

@Repository
public interface FavoriteRepository extends JpaRepository<ReviewBoardFavoriteEntity, FavoritePk> {
  
  boolean existsByUserEmailAndBoardNumber(String writerEmail, Integer boardNumber);

  @Transactional
  void deleteByBoardNumber(Integer boardNumber);
}
