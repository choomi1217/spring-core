package com.example.springcore1.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springcore1.domain.Member;
import com.example.springcore1.repository.MemberRepository;
import com.example.springcore1.repository.MemoryMemberRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memberRepository);

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");

        Long saveId = memberService.join(member).getId();

        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void validateDuplicateMember() {
        Member member1 = new Member();
        member1.setName("dup");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("dup");

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.join(member2);

        List<Member> members = memberService.findMembers();
        assertEquals(2, members.size());
    }

    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member result = memberService.findOne(member1.getId()).get();
        assertEquals(member1, result);
    }
}
