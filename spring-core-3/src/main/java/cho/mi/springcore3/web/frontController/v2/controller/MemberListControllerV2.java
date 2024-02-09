package cho.mi.springcore3.web.frontController.v2.controller;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.MyView;
import cho.mi.springcore3.web.frontController.v2.ControllerV2;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        List<Member> all = memberRepository.findAll();

        request.setAttribute("members", all);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
