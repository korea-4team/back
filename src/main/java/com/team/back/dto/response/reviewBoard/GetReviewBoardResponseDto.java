package com.team.back.dto.response.reviewBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.ReviewBoardViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetReviewBoardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String contents;
  private String imageUrl;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  
  private GetReviewBoardResponseDto(String code, String message, ReviewBoardViewEntity reviewBoardViewEntity) {
    super(code, message);
    this.boardNumber = reviewBoardViewEntity.getBoardNumber();
    this.title = reviewBoardViewEntity.getTitle();
    this.contents = reviewBoardViewEntity.getContents();
    this.imageUrl = reviewBoardViewEntity.getImageUrl();
    this.writeDatetime = reviewBoardViewEntity.getWriteDatetime();
    this.writerEmail = reviewBoardViewEntity.getWriterEmail();
    this.writerNickname = reviewBoardViewEntity.getWriterNickname();
  }

  public static ResponseEntity<GetReviewBoardResponseDto> success(ReviewBoardViewEntity reviewBoardViewEntity) {
    GetReviewBoardResponseDto result = new GetReviewBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, reviewBoardViewEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
  public static ResponseEntity<ResponseDto> noExistedBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  
}
