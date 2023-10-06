package com.team.back.provider;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailProvider {
    
    private final JavaMailSender javaMailSender;

    public void sendMail(String email, String temporaryPassword) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("임시 비밀번호입니다.");
        simpleMailMessage.setText("임시 비밀번호 : " + temporaryPassword);
        javaMailSender.send(simpleMailMessage);
    }

}
