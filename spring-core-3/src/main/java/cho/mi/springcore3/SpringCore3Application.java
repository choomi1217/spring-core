package cho.mi.springcore3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan
@SpringBootApplication
public class  SpringCore3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCore3Application.class, args);
    }

}
