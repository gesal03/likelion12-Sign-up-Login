package com.example.account.account.service;

import com.example.account.account.dto.SignUpDto;
import com.example.account.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface MemberService {
    public ResponseEntity<CustomApiResponse<?>> signUp(SignUpDto.Req req);
}
