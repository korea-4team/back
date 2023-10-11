package com.team.back.dto.response.myPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.resultSet.UserReservationListResultSet;

import lombok.Getter;

@Getter
public class GetMyReservationListResponseDto extends ResponseDto {
    
    private List<UserReservationDto> myReservationList;

    private GetMyReservationListResponseDto(List<UserReservationListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myReservationList = UserReservationDto.copyList(resultSets);
    }

    public static ResponseEntity<GetMyReservationListResponseDto> success(List<UserReservationListResultSet> resultSets) {
        GetMyReservationListResponseDto result = new GetMyReservationListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
