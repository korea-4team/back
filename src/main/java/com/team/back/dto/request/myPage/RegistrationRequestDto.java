package com.team.back.dto.request.myPage;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {
    
    @NotBlank
    private String storeNumber;
    @NotBlank
    private String storeName;
    @NotBlank
    private String address;
    private String addressDetail;
    @NotBlank
    private String businessType;
    @NotBlank
    private String storeStartHours;
    @NotBlank
    private String storeFinishHours;
    @NotBlank
    private String storeTelNumber;

}
