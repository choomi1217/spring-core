package com.example.springcore5.login;

import domain.item.Item;
import domain.item.ItemRepository;
import domain.member.Member;
import domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 5000, 5));

        Member member = new Member();
        member.setLoginId("user");
        member.setPassword("user!");
        member.setName("userA");

        memberRepository.save(member);
    }

}
