package com.ll.chat_ai.domain.member.dto;

import com.ll.chat_ai.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private final String username;

    public MemberDto(Member member) {
        this.username = member.getUsername();
    }
}
