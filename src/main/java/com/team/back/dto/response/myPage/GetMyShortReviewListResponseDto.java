package com.team.back.dto.response.myPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.resultSet.UserShortReviewListResultSet;

import lombok.Getter;

@Getter
public class GetMyShortReviewListResponseDto extends ResponseDto {
    private List<UserShortReviewDto> myShortReviewList;

    private GetMyShortReviewListResponseDto (List<UserShortReviewListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myShortReviewList = UserShortReviewDto.copyList(resultSets);
    }

    public static ResponseEntity<GetMyShortReviewListResponseDto> success(List<UserShortReviewListResultSet> resultSets) {
        GetMyShortReviewListResponseDto result = new GetMyShortReviewListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
