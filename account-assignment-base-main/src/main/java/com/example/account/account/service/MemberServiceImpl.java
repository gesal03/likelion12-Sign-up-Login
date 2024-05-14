package com.example.account.account.service;

import com.example.account.account.domain.Member;
import com.example.account.account.dto.SignUpDto;
import com.example.account.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public ResponseEntity<CustomApiResponse<?>> signUp(SignUpDto.Req req) {
        Member member = req.toEntity();


    }
}
