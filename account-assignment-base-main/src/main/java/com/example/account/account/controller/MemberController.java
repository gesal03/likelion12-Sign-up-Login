package com.example.account.account.controller;

import com.example.account.account.dto.SignUpDto;
import com.example.account.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public RequestEntity<CustomApiResponse<?>> signUp(@Valid @RequestBody SignUpDto.Req req) {
        return memberService.signUp(req);
    }

    @PostMapping("/login")
    public RequestEntity<CustomApiResponse<?>> logIn() {
        return memberService.logIn();
    }

    @DeleteMapping("/withdraw/{memberId}")
    public RequestEntity<CustomApiResponse<?>> deleteMember() {
        return memberService.deleteMember();
    }
}
