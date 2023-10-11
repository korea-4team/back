package com.team.back.dto.response.myPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.resultSet.UserCommentListResultSet;

import lombok.Getter;

@Getter
public class GetMyCommentListResponseDto extends ResponseDto {
    
    private List<UserReviewCommentDto> myCommentList;

    private GetMyCommentListResponseDto (List<UserCommentListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myCommentList = UserReviewCommentDto.copyList(resultSets);
    }

    public static ResponseEntity<GetMyCommentListResponseDto> success(List<UserCommentListResultSet> resultSets) {
        GetMyCommentListResponseDto result = new GetMyCommentListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
