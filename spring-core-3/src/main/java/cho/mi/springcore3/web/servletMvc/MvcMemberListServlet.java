package cho.mi.springcore3.web.servletMvc;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet/mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> all = memberRepository.findAll();

        req.setAttribute("members", all);

        String viewPath = "/WEB-INF/views/members.jsp";
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }
}
