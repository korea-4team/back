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
@Entity(name = "event_board_view")
@Table(name = "event_board_view")
public class EventBoardViewEntity {

    @Id
	private int boardNumber;
	private String title;
	private String contents;
	private String imageUrl;
	private String writeDatetime;
	private String writerEmail;
	private String writerNickname;
}
