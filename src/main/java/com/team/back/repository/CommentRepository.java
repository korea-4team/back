package com.team.back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.back.entity.CommentEntity;
import com.team.back.entity.resultSet.CommentListResultSet;

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
    "ORDER BY RC.write_datetime DESC",
    nativeQuery=true
  )
  List<CommentListResultSet> getUserCommentList();



  @Transactional
  void deleteByBoardNumber(Integer boardNumber);

  @Transactional
  void deleteByCommentNumber(Integer commmentNumber);
}
