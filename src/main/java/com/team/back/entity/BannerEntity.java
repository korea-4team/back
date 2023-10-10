package com.team.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.banner.PatchBannerRequestDto;
import com.team.back.dto.request.banner.PostBannerRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "banner")
@Table(name = "banner")
public class BannerEntity {
    @Id
    private int bannerNumber;

    private String imageUrl;

    private int sequence;

    private int eventBoardNumber;

    private String writerEmail;

    private String writeDatetime;

    public BannerEntity(String writerEmail, int eventBoardNumber, PostBannerRequestDto dto) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String writeDatetime = simpleDateFormat.format(now);

        this.imageUrl = dto.getImageUrl();
        this.sequence = dto.getSequence();
        this.eventBoardNumber = eventBoardNumber;
        this.writeDatetime = writeDatetime;
        this.writerEmail = writerEmail;
    }

    public void patch(PatchBannerRequestDto dto) {
        this.imageUrl = dto.getImageUrl();
        this.sequence = dto.getSequence();
    }
}
