package com.team.back.dto.response.eventBoard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchEventBoardResponseDto extends ResponseDto {
    
    private PatchEventBoardResponseDto (String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PatchEventBoardResponseDto> success () {
        PatchEventBoardResponseDto result = new PatchEventBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
        ResponseDto result = new PatchEventBoardResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistedBoard() {
        ResponseDto result = new PatchEventBoardResponseDto(ResponseCode.NO_EXISTED_BOARD, ResponseMessage.NO_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noPermission() {
        ResponseDto result = new PatchEventBoardResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }

}
