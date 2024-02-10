package cho.mi.springcore3.web.frontController.v3.controller;

import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.ModelView;
import cho.mi.springcore3.web.frontController.v3.ControllerV3;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", memberRepository.findAll());
        return modelView;
    }
}
