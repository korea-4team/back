package com.team.back.dto.response.myPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.resultSet.UserReservationListResultSet;
import com.team.back.entity.resultSet.UserStoreReservationListResultSet;

import lombok.Getter;

@Getter
public class GetMyStoreReservationListResponseDto extends ResponseDto {
    private List<UserStoreReservationDto> myStoreReservationList;

    private GetMyStoreReservationListResponseDto(List<UserStoreReservationListResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myStoreReservationList = UserStoreReservationDto.copyList(resultSets);
    }

    public static ResponseEntity<GetMyStoreReservationListResponseDto> success(List<UserStoreReservationListResultSet> resultSets) {
        GetMyStoreReservationListResponseDto result = new GetMyStoreReservationListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
