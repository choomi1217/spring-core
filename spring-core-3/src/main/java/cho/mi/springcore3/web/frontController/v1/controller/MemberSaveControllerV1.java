package cho.mi.springcore3.web.frontController.v1.controller;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.v1.ControllerV1;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSaveControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        request.setAttribute("member", member);
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
