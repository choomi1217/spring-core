package cho.mi.springcore3.web.frontController.v3.controller;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.ModelView;
import cho.mi.springcore3.web.frontController.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
         String string = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(string, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
