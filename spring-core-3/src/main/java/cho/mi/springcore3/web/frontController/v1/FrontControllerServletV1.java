package cho.mi.springcore3.web.frontController.v1;

import cho.mi.springcore3.web.frontController.v1.controller.MemberFormControllerV1;
import cho.mi.springcore3.web.frontController.v1.controller.MemberListControllerV1;
import cho.mi.springcore3.web.frontController.v1.controller.MemberSaveControllerV1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ControllerV1 controllerV1 = controllerMap.get(request.getRequestURI());
        if (controllerV1 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controllerV1.process(request, response);
    }
}
