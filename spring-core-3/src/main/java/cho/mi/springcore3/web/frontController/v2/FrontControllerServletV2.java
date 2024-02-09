package cho.mi.springcore3.web.frontController.v2;

import cho.mi.springcore3.web.frontController.MyView;
import cho.mi.springcore3.web.frontController.v1.ControllerV1;
import cho.mi.springcore3.web.frontController.v2.controller.MemberFormControllerV2;
import cho.mi.springcore3.web.frontController.v2.controller.MemberListControllerV2;
import cho.mi.springcore3.web.frontController.v2.controller.MemberSaveControllerV2;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ControllerV2 controllerV2  = controllerMap.get(request.getRequestURI());
        if (controllerV2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view  = controllerV2.process(request, response);
        view.render(request, response);
    }
}
