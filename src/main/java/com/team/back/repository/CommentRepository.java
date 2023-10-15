package com.team.back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.back.entity.CommentEntity;
import com.team.back.entity.resultSet.CommentListResultSet;
import com.team.back.entity.resultSet.UserCommentListResultSet;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

  CommentEntity findByCommentNumber(Integer commentNumber);
  
   @Query(
    value=
    "SELECT " +
    "U.nickname AS nickname, " +
    "RC.contents AS contents, " +
    "RC.write_datetime AS writeDatetime " +
    "FROM review_board_comment AS RC INNER JOIN user AS U " +
    "ON RC.user_email = U.email " +
    "WHERE board_number = ?1 " +
    "ORDER BY RC.write_datetime DESC",
    nativeQuery=true
  )
  List<CommentListResultSet> getCommentList(Integer boardNumber);

  @Query(
    value=
    "SELECT " +
    "U.nickname AS nickname, " +
    "RC.contents AS contents, " +
    "RC.write_datetime AS writeDatetime " +
    "FROM review_board_comment AS RC INNER JOIN user AS U " +
    "ON RC.user_email = U.email " +
    "WHERE RC.user_email = ?1 " +
    "ORDER BY RC.write_datetime DESC " +
    "LIMIT ?2, 30",
    nativeQuery=true
  )
  List<CommentListResultSet> getUserCommentList(String userEmail, Integer section);

  @Query(
        value = 
        "SELECT " + 
	        "C.comment_number as commentNumber, " +
	        "C.contents as contents, " + 
	        "C.write_datetime as writeDatetime, " +
	        "R.board_number as boardNumber, " +
	        "R.title as title, " +
	        "R.image_url as imageUrl " +
        "FROM review_board_comment C " +
        "LEFT JOIN review_board R " +
        "ON C.board_number = R.board_number " +
        "WHERE C.user_email = 1? " +
        "ORDER BY C.write_datetime DESC",
        nativeQuery=true
  )
  List<UserCommentListResultSet> getMyCommentList(String email);

  @Transactional
  void deleteByBoardNumber(Integer boardNumber);

  @Transactional
  void deleteByCommentNumber(Integer commmentNumber);
}
