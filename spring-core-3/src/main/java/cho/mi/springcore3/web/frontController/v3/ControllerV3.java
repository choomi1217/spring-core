package cho.mi.springcore3.web.frontController.v3;

import cho.mi.springcore3.web.frontController.ModelView;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
