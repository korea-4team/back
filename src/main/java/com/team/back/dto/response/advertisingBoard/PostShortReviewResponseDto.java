package com.team.back.dto.response.advertisingBoard;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.ShortReviewResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostShortReviewResponseDto {
    private String nickname;
    private String writeDatetime;
    private String contents;
  

    public PostShortReviewResponseDto(ShortReviewResultSet resultSet){
      this.nickname = resultSet.getNickname();
      this.writeDatetime = resultSet.getWriteDatetime();
      this.contents = resultSet.getContnts();
    }

    public static List<PostShortReviewResponseDto> copyList(List<ShortReviewResultSet> resultSets) {
      
      List<PostShortReviewResponseDto> shortreviewList = new ArrayList<>();

      for (ShortReviewResultSet resultSet: resultSets){
        PostShortReviewResponseDto commentItem = new PostShortReviewResponseDto(resultSet);
        shortreviewList.add(commentItem);
      }
      return shortreviewList;
    }
}
