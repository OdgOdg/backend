package com.itg.itg.controller;

import com.itg.itg.dto.MemberRegisterDto;
import com.itg.itg.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public String register(@RequestBody MemberRegisterDto dto) {
        return memberService.registerMember(dto);
    }
}
