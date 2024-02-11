package cho.mi.springcore3.web.frontController.v5;

import cho.mi.springcore3.web.frontController.ModelView;
import cho.mi.springcore3.web.frontController.MyView;
import cho.mi.springcore3.web.frontController.v3.controller.MemberFormControllerV3;
import cho.mi.springcore3.web.frontController.v3.controller.MemberListControllerV3;
import cho.mi.springcore3.web.frontController.v3.controller.MemberSaveControllerV3;
import cho.mi.springcore3.web.frontController.v4.controller.MemberFormControllerV4;
import cho.mi.springcore3.web.frontController.v4.controller.MemberListControllerV4;
import cho.mi.springcore3.web.frontController.v4.controller.MemberSaveControllerV4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMap = new HashMap<>();

    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMap();
        initHandlerAdapter();
    }

    private void initHandlerMap() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
        handlerMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapter() {
        handlerAdapters.add(new ControllerV3Adapter( ));
        handlerAdapters.add(new ControllerV4Adapter( ));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Object handler = getHandler(req);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        ModelView modelView = handlerAdapter.handle(req, resp, handler);

        MyView view = viewResolver(modelView.getViewName());

        view.render(modelView.getModel(), req, resp);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)) {
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("handler adapter not found. handler = " + handler);
    }

    private Object getHandler(HttpServletRequest req) {
        return handlerMap.get(req.getRequestURI());
    }
}
