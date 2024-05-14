package com.example.account.account.controller;

import com.example.account.account.dto.LogInDto;
import com.example.account.account.dto.SignUpDto;
import com.example.account.account.service.MemberService;
import com.example.account.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/sign-up")
    public ResponseEntity<CustomApiResponse<?>> signUp(@Valid @RequestBody SignUpDto.Req req) {
        return memberService.signUp(req);
    }
    @PostMapping("/login")
    public ResponseEntity<CustomApiResponse<?>> logIn(@RequestBody LogInDto.Req req) {
        return memberService.logIn(req);
    }
    @DeleteMapping("/withdraw/{userId}")
    public ResponseEntity<CustomApiResponse<?>> deleteMember(@PathVariable("userId") String userId) {
        return memberService.deleteMember(userId);
    }
}
