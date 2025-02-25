package com.itg.itg.service;

import com.itg.itg.dto.MemberRegisterDto;
import com.itg.itg.entity.Member;
import com.itg.itg.repository.MemberRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String registerMember(MemberRegisterDto dto) {
        if (memberRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        Member member = dto.toEntity(encodedPassword);
        memberRepository.save(member);
        return "회원가입 성공!";
    }
}
