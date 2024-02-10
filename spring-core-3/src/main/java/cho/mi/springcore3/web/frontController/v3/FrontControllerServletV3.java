package cho.mi.springcore3.web.frontController.v3;

import cho.mi.springcore3.web.frontController.ModelView;
import cho.mi.springcore3.web.frontController.MyView;
import cho.mi.springcore3.web.frontController.v3.controller.MemberFormControllerV3;
import cho.mi.springcore3.web.frontController.v3.controller.MemberListControllerV3;
import cho.mi.springcore3.web.frontController.v3.controller.MemberSaveControllerV3;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ControllerV3 controllerV3 = controllerMap.get(request.getRequestURI());
        if (controllerV3 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controllerV3.process(paramMap);
        MyView view = viewResolver(modelView.getViewName());

        view.render(modelView.getModel(), request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
            .forEachRemaining(
                paramName ->  paramMap.put(paramName, request.getParameter(paramName))
            );
        return paramMap;
    }
}
