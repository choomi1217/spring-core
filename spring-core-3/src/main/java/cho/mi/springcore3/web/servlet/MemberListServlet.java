package cho.mi.springcore3.web.servlet;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("    <meta charset=\"UTF-8\">");
        resp.getWriter().write("    <title>Title</title>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("    <a href=\"/index.html\">메인</a>");
        resp.getWriter().write("    <table>");
        resp.getWriter().write("        <thead>");
        resp.getWriter().write("            <th>id</th>");
        resp.getWriter().write("            <th>username</th>");
        resp.getWriter().write("            <th>age</th>");
        resp.getWriter().write("        </thead>");
        resp.getWriter().write("        <tbody>");

        for (Member m: memberRepository.findAll()) {
            resp.getWriter().write("            <tr>");
            resp.getWriter().write("                <td>" + m.getId() + "</td>");
            resp.getWriter().write("                <td>" + m.getName() + "</td>");
            resp.getWriter().write("                <td>" + m.getAge() + "</td>");
            resp.getWriter().write("            </tr>");
        }

        resp.getWriter().write("        </tbody>");
        resp.getWriter().write("    </table>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
