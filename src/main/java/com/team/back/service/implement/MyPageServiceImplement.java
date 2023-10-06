package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.myPage.RegistrationRequestDto;
import com.team.back.dto.response.myPage.RegistrationResponseDto;
import com.team.back.entity.BusinessApplicationEntity;
import com.team.back.repository.BusinessApplicationRepository;
import com.team.back.repository.BusinessNumberRepository;
import com.team.back.service.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService {
    
    private final BusinessNumberRepository businessNumberRepository;
    private final BusinessApplicationRepository businessApplicationRepository;

    @Override
    public ResponseEntity<? super RegistrationResponseDto> registration(RegistrationRequestDto dto, String email) {

        String storeNumber = dto.getStoreNumber();

        try {

            boolean existedStoreNumber = businessNumberRepository.existsByStoreNumber(storeNumber);
            if (existedStoreNumber) return RegistrationResponseDto.existStoreNumber();

            BusinessApplicationEntity businessApplicationEntity = new BusinessApplicationEntity(dto, email);
            businessApplicationRepository.save(businessApplicationEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return RegistrationResponseDto.success();

    }

}
