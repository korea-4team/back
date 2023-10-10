package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.auth.AccountFindEmailRequestDto;
import com.team.back.dto.request.auth.AccountFindPasswordRequestDto;
import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.request.auth.SignUpRequestDto;
import com.team.back.dto.response.auth.AccountFindEmailResponseDto;
import com.team.back.dto.response.auth.AccountFindPasswordResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.auth.SignUpResponseDto;
import com.team.back.entity.AdminEntity;
import com.team.back.entity.UserEntity;
import com.team.back.provider.EmailProvider;
import com.team.back.provider.JwtProvider;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.AuthService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final JwtProvider jwtProvider;
    private final EmailProvider emailProvider;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        try {

            AdminEntity adminEntity = adminRepository.findByAdminId(email);

            if(adminEntity != null) {
                String encodedPassword = adminEntity.getAdminPassword();
                boolean equalPassword = passwordEncoder.matches(password, encodedPassword);

                if (!equalPassword) return SignInResponseDto.signInDataMismatch();
            }

            else {
                UserEntity userEntity = userRepository.findByEmail(email);

                if (userEntity == null) return SignInResponseDto.signInDataMismatch();

                String encodedPassword = userEntity.getPassword();
                boolean equalPassword = passwordEncoder.matches(password, encodedPassword);
                if (!equalPassword) return SignInResponseDto.signInDataMismatch();
            }

            token = jwtProvider.create(email);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
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

    @Override
    public ResponseEntity<? super AccountFindEmailResponseDto> accountFindEmail(AccountFindEmailRequestDto dto) {
        
        String telNumber = dto.getTelNumber();
        String email = null;

        try {

            UserEntity userEntity = userRepository.findByTelNumber(telNumber);
            if (userEntity == null) return AccountFindEmailResponseDto.notExistUser();

            email = userEntity.getEmail();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return AccountFindEmailResponseDto.success(email);

    }

    @Override
    public ResponseEntity<? super AccountFindPasswordResponseDto> accountFindPassword(
            AccountFindPasswordRequestDto dto) {

        String email = dto.getEmail();
        String telNumber = dto.getTelNumber();

        try {

            UserEntity userEntity = userRepository.findByEmailAndTelNumber(email, telNumber);
            if (userEntity == null) return AccountFindPasswordResponseDto.notExistUser();

            // description : 임시 비밀번호로 변경 //
            String temporaryPassword = RandomString.make(8);
            String encodedTemporaryPassword = passwordEncoder.encode(temporaryPassword);

            userEntity.setPassword(encodedTemporaryPassword);
            userRepository.save(userEntity);

            // description: 임시 비밀번호 전송 //
            emailProvider.sendMail(email, temporaryPassword);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return AccountFindPasswordResponseDto.success();
    }


}
