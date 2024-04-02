package com.example.springcore5.login.web;

import com.example.springcore5.login.LoginService;
import com.example.springcore5.session.SessionManager;
import com.example.springcore5.member.domain.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    //@PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        try {
            Member logined = loginService.login(form.getLoginId(), form.getPassword());

            Cookie cookie = new Cookie("memberId", String.valueOf(logined.getId()));
            response.addCookie(cookie);

            return "redirect:/";
        } catch (IllegalStateException e) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
    }

    @PostMapping("/login")
    public String loginV2(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        try {
            Member logined = loginService.login(form.getLoginId(), form.getPassword());
            sessionManager.createSession(logined, response);

            return "redirect:/";
        } catch (IllegalStateException e) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
    }

    //@GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        expireCookie(response);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutV2(HttpServletRequest request, HttpServletResponse response) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
