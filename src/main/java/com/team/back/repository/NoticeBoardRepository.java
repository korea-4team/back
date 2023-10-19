package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.NoticeBoardEntity;
import com.team.back.entity.resultSet.NoticeBoardListResultSet;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity, Integer> {
	
	NoticeBoardEntity findByBoardNumber(Integer boardNumber);

	@Query(
		value =
			"SELECT " +
			"N.board_number AS boardNumber, " +
			"N.title AS title, " +
			"N.contents AS contents, " +
			"N.image_url AS imageUrl, " +
			"N.write_datetime AS writeDatetime, " +
			"A.admin_id AS writerEmail, " +
			"A.admin_nickname AS writerNickname " +
			"FROM notice_board AS N " +
			"INNER JOIN admin AS A " +
			"ON N.writer_email = A.admin_id " +
			"ORDER BY N.write_datetime DESC, N.board_number DESC ",
		nativeQuery = true
	)
	List<NoticeBoardListResultSet> getNoticeBoardList(Integer section);

}
