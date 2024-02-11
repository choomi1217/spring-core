package cho.mi.springcore3.web.frontController.v5;

import cho.mi.springcore3.web.frontController.ModelView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

    public boolean supports(Object handler);

    public ModelView handle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws ServletException, IOException;
}
