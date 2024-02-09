package cho.mi.springcore3.web.servletMvc;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet/mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        req.setAttribute("member", member);
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }
}
