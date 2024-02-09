package cho.mi.springcore3.web.frontController.v2.controller;

import cho.mi.springcore3.web.frontController.MyView;
import cho.mi.springcore3.web.frontController.v2.ControllerV2;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
