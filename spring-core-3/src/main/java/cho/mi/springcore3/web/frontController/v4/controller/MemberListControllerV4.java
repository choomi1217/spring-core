package cho.mi.springcore3.web.frontController.v4.controller;

import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.ModelView;
import cho.mi.springcore3.web.frontController.v3.ControllerV3;
import cho.mi.springcore3.web.frontController.v4.ControllerV4;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("members", memberRepository.findAll());
        return "members";
    }
}
