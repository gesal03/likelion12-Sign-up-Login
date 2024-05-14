package com.example.account.account.service;

import com.example.account.account.domain.Member;
import com.example.account.account.dto.SignUpDto;
import com.example.account.account.repository.MemberRepository;
import com.example.account.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    public ResponseEntity<CustomApiResponse<?>> signUp(SignUpDto.Req req) {

        Member member = req.toEntity();
        // 회원 가입
        Member savedMember = memberRepository.save(member);
        // data 생성
        SignUpDto.CreateMember createdMember = new SignUpDto.CreateMember(savedMember.getId(), savedMember.getUpdatedAt().atStartOfDay());
        // responseBody
        CustomApiResponse<SignUpDto.CreateMember> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), createdMember, "회원가입이 완료되었습니다.");
        // ResponseEntity
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
