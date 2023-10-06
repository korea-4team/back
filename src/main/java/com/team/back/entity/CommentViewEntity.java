package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment_view")
@Table(name = "comment_view")
public class CommentViewEntity {
	@Id
	private int commentNumber;
	private int boardNumber;
	private String userEmail;
	private String userNickname;
	private String contents;
	private String writeDatetime;
}
