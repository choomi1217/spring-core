package com.example.springcore5;

import domain.member.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginHomeController {

    private final MemberRepository memberRepository;

    //@GetMapping("/")
    public String loginHome() {
        return "redirect:/items";
    }

    @GetMapping("/")
    public String loginHome(@CookieValue(value = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null) {
            return "home";
        }

        model.addAttribute("member", memberRepository.findById(memberId));
        return "loginHome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        expireCookie(response);
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
