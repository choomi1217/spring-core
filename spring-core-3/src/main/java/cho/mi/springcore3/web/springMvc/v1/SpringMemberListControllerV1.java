package cho.mi.springcore3.web.springMvc.v1;

import cho.mi.springcore3.domain.member.MemberRepository;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("members", memberRepository.findAll());
        return modelAndView;
    }
}
