package com.itg.itg.dto;

import com.itg.itg.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterDto {
    private String username;
    private String password;
    private String email;

    public Member toEntity(String encodedPassword) {
        return new Member(username, encodedPassword, email);
    }
}
