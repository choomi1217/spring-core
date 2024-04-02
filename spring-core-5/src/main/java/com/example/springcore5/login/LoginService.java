package com.example.springcore5.login;

import com.example.springcore5.member.domain.Member;
import com.example.springcore5.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElseThrow(() -> new IllegalStateException("login failure"));
    }

}
