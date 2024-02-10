package cho.mi.springcore3.web.frontController;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {

    private final String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher(viewPath).forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException  {
        modelToRequestAttribute(model, request);
        request.getRequestDispatcher(viewPath).forward(request, response);
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach(request::setAttribute);
    }
}
