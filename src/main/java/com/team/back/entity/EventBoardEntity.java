package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.eventBoard.PatchEventBoardRequestDto;
import com.team.back.dto.request.eventBoard.PostEventBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "event_board")
@Table(name = "event_board")
public class EventBoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String title;
	private String contents;
	private String imageUrl;
	private String writeDatetime;
	private String writerEmail;

    public EventBoardEntity(String writerEmail, PostEventBoardRequestDto dto) {
        Date now = Date.from(Instant.now());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String writeDatetime = simpleDateFormat.format(now);

		this.title = dto.getTitle();
		this.contents = dto.getContents();
		this.imageUrl = dto.getImageUrl();
		this.writeDatetime = writeDatetime;
		this.writerEmail = writerEmail;
    }

    public void patch(PatchEventBoardRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.imageUrl = dto.getImageUrl();
    }
}
