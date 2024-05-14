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
        // 중복 확인
        if (memberRepository.findByUserId(req.getUserId()).isPresent()) {
            CustomApiResponse<Object> responseBody = CustomApiResponse.createFailWithoutData(HttpStatus.FORBIDDEN.value(), "중복된 사용자 계정이 있습니다.");
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(responseBody);

        }
        // 비밀번호 일치 여부 파악
        if (req.getPassword() != req.getPasswordCheck()) {
            CustomApiResponse<Object> responseBody = CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "비밀번호가 일치하지 않습니다.");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseBody);
        }
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
