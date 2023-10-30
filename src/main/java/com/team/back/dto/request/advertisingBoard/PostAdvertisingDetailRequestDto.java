package com.team.back.dto.request.advertisingBoard;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAdvertisingDetailRequestDto {

    public String storeName;
    public String storeTel;
    public String storeTime;
    public String storeNumber;
    public String storeAddress;



}
