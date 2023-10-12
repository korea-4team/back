package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.BannerEntity;
import com.team.back.entity.resultSet.MainBannerListResultSet;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Integer>{
    
    boolean existsByBannerNumber(int bannerNumber);

    BannerEntity findByBannerNumber(Integer BannerNumber);

    @Query(
    value =
        "SELECT " +
        "banner_number AS bannerNumber, " +
        "image_url AS imageUrl, " +
        "sequence, " +
        "write_datetime AS writeDatetime, " +
        "writer_email AS writerEmail, " +
        "event_board_number AS eventBoardNumber " +
        "FROM banner " +
        "ORDER BY sequence",
    nativeQuery = true
	)
    List<MainBannerListResultSet> getMainBannerList();
}
