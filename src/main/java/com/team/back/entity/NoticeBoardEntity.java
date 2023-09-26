package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.noticeBoard.PatchNoticeBoardRequestDto;
import com.team.back.dto.request.noticeBoard.PostNoticeBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="notice_board")
@Table(name = "notice_board")
public class NoticeBoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNumber;

	private String title;

	private String contents;

	private String imageUrl;

	private String writeDatetime;

	private String writerEmail;

	public NoticeBoardEntity(String writerEmail, PostNoticeBoardRequestDto dto) {
		Date now = Date.from(Instant.now());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String writeDatetime = simpleDateFormat.format(now);

		this.title = dto.getTitle();
		this.contents = dto.getContents();
		this.imageUrl = dto.getImageUrl();
		this.writeDatetime = writeDatetime;
		this.writerEmail = writerEmail;
	}

	// 공지사항 수정 시
	public void patch(PatchNoticeBoardRequestDto dto) {
		this.title = dto.getTitle();
		this.contents = dto.getContents();
		this.imageUrl = dto.getImageUrl();
	}
}
