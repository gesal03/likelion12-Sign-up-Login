package com.example.account.account.dto;

import com.example.account.account.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

public class SignUpDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        @NotBlank(message = "사용자 계정은 비어 있을 수 없습니다.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "사용자 계정은 영문과 숫자만 포함 가능합니다.")
        private String userId;
        @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
        private String password;
        @NotBlank(message = "비밀번호(확인)은 비어 있을 수 없습니다.")
        private String passwordCheck;
        @Email(message = "Email 형식이 맞지 않습니다.")
        private String email;
        @Pattern(regexp = "^010\\d{8}$", message = "전화번호 형식이 맞지 않습니다.")
        private String phone;
        public Member toEntity() {
            return Member.builder()
                    .userId(userId)
                    .password(password)
                    .email(email)
                    .phone(phone)
                    .build();
        }
    }
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMember {
        private Long memberId;
        private LocalDateTime updatedAt;
    }
}
