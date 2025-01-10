package com.ll.chat_ai.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRequest {
    @NotBlank
    private final String username;

    @NotBlank
    private final String password;
}
