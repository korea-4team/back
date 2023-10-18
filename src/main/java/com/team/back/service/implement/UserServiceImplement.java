package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.user.GetSignInUserResponseDto;
import com.team.back.entity.AdminEntity;
import com.team.back.entity.UserEntity;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
        
        UserEntity userEntity = null;

        try {

            AdminEntity adminEntity = adminRepository.findByAdminId(email);
            if (adminEntity != null) return GetSignInUserResponseDto.success(adminEntity);

            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return GetSignInUserResponseDto.notExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);

    }
    
    

}
