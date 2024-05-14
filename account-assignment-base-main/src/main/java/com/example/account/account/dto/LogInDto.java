package com.example.account.account.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class LogInDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        @NotBlank(message = "사용자 계정은 비어 있을 수 없습니다.")
        private String userId;
        @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
        private String password;
    }
}
