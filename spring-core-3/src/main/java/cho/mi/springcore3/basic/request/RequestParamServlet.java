package cho.mi.springcore3.basic.request;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
            .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");

        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        System.out.println("username = " + req.getParameter("username"));
        System.out.println("age = " + req.getParameter("age"));
        System.out.println("[단일 파라미터 조회] - end");

        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        for (String username : req.getParameterValues("username")) {
            System.out.println("username = " + username);
        }


    }
}
