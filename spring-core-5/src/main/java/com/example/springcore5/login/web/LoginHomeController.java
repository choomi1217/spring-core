package com.example.springcore5.login.web;

import com.example.springcore5.member.domain.Member;
import com.example.springcore5.member.domain.MemberRepository;
import com.example.springcore5.session.SessionConst;
import com.example.springcore5.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class LoginHomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    //@GetMapping("/")
    public String loginHome() {
        return "redirect:/items";
    }

    //@GetMapping("/")
    public String loginHome(@CookieValue(value = "memberId", required = false) Long memberId,
        Model model) {
        if (memberId == null) {
            return "home";
        }

        model.addAttribute("member", memberRepository.findById(memberId));
        return "loginHome";
    }

    //@GetMapping("/")
    public String loginHomeV2(HttpServletRequest request, Model model) {
        Member member = (Member) sessionManager.getSession(request);
        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

    //@GetMapping("/")
    public String loginHomeV3(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "home";
        }

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

    @GetMapping("/")
    public String loginHomeV3Spring(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member, Model model) {
        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

}
