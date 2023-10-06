package com.team.back.dto.response.myPage;

import java.util.List;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.resultSet.MyReservationResultSet;

import lombok.Getter;

@Getter
public class GetReservationListResponseDto extends ResponseDto {
    
    private List<ReservationListResponseDto> reservationList;

    public GetReservationListResponseDto(List<MyReservationResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.reservationList = ReservationListResponseDto.copyList(resultSets);
    }

}
