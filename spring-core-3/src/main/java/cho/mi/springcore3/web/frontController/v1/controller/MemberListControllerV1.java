package cho.mi.springcore3.web.frontController.v1.controller;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.v1.ControllerV1;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Member> all = memberRepository.findAll();

        request.setAttribute("members", all);

        String viewPath = "/WEB-INF/views/members.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
