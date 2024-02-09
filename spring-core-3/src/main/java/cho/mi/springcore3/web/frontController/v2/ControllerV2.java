package cho.mi.springcore3.web.frontController.v2;

import cho.mi.springcore3.web.frontController.MyView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface  ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response);

}
