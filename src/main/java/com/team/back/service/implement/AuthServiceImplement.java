package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.request.auth.SignUpRequestDto;
import com.team.back.dto.ResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.auth.SignUpResponseDto;
import com.team.back.entity.UserEntity;
import com.team.back.provider.JwtProvider;
import com.team.back.repository.UserRepository;
import com.team.back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        try {
            UserEntity userEntity = userRepository.findByEmail(email);

            if (userEntity == null) return SignInResponseDto.signInDataMismatch();

            String encodedPassword = userEntity.getPassword();
            boolean equalPassword = passwordEncoder.matches(password, encodedPassword);
            if (!equalPassword) return SignInResponseDto.signInDataMismatch();

            token = jwtProvider.create(email);

        } catch(Exception exception) {

        }

        return SignInResponseDto.success(token);
    }
    
    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();
        String nickname = dto.getNickname();
        String telNumber = dto.getTelNumber();

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if (hasEmail) return SignUpResponseDto.existedEmail();

            boolean hasNickname = userRepository.existsByNickname(nickname);
            if (hasNickname) return SignUpResponseDto.existedNickname();

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return SignUpResponseDto.existedTelNumber();

            password = passwordEncoder.encode(password);

            dto.setPassword(password);

            UserEntity userEntity = new UserEntity(dto);

            userRepository.save(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }
}
