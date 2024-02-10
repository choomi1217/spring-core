package cho.mi.springcore3.web.frontController.v4.controller;

import cho.mi.springcore3.domain.member.Member;
import cho.mi.springcore3.domain.member.MemberRepository;
import cho.mi.springcore3.web.frontController.v4.ControllerV4;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String string = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(string, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-resu lt";
    }
}
