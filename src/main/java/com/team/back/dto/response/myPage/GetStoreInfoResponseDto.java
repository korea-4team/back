package com.team.back.dto.response.myPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.ResponseDto;
import com.team.back.entity.BusinessNumberEntity;

import lombok.Getter;

@Getter
public class GetStoreInfoResponseDto extends ResponseDto {
    
    private String storeNumber;
    private String storeName;
    private String address;
    private String addressDetail;
    private String businessType;
    private String ownerName;
    private String startHours;
    private String finishHours;
    private String telNumber;

    private GetStoreInfoResponseDto(BusinessNumberEntity businessNumberEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.storeNumber = businessNumberEntity.getStoreNumber();
        this.storeName = businessNumberEntity.getStoreName();
        this.address = businessNumberEntity.getAddress();
        this.addressDetail = businessNumberEntity.getAddressDetail();
        this.businessType = businessNumberEntity.getBusinessType();
        this.ownerName = businessNumberEntity.getOwnerName();
        this.startHours = businessNumberEntity.getStartHours();
        this.finishHours = businessNumberEntity.getFinishHours();
        this.telNumber = businessNumberEntity.getTelNumber();
    }

    public static ResponseEntity<GetStoreInfoResponseDto> success(BusinessNumberEntity businessNumberEntity) {
        GetStoreInfoResponseDto result = new GetStoreInfoResponseDto(businessNumberEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistStore() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_STORE, ResponseMessage.NO_EXISTED_STORE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

    public static ResponseEntity<ResponseDto> notAdminId() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_ADMIN_ID, ResponseMessage.NOT_ADMIN_ID);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

}
