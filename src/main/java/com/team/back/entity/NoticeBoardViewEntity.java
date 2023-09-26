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
@Entity(name = "notice_board_view")
@Table(name = "notice_board_view")
public class NoticeBoardViewEntity {
	
	@Id
	private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String writeDatetime;
	private String writerEmail;
	private String writerNickname;

}
