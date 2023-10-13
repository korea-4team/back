package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.team.back.dto.request.advertisingBoard.PostTagRequestDto;
import com.team.back.entity.pk.TagPk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tag")
@Table(name = "tag")
@IdClass(TagPk.class)
public class TagEntity {

  @Id
  private int boardNumber;
  
  @Id
  private String tagWord;
  
  public TagEntity(int boardNumber, PostTagRequestDto dto) {
    this.tagWord = dto.getTagWord();
    this.boardNumber = boardNumber;
  }
}
