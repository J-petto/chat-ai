package com.ll.chat_ai.domain.member.member.service;

import com.ll.chat_ai.global.RsData.RsData;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password) {
        Member member = Member.builder().username(username).password(password).build();
        memberRepository.save(member);
        return RsData.of("200", "성공", member);
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }
}
