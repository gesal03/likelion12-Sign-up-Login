package com.example.account.account.service;

import com.example.account.account.dto.LogInDto;
import com.example.account.account.dto.SignUpDto;
import com.example.account.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<CustomApiResponse<?>> signUp(SignUpDto.Req req);

    ResponseEntity<CustomApiResponse<?>> logIn(LogInDto.Req req);

    ResponseEntity<CustomApiResponse<?>> deleteMember(String userId);

}
