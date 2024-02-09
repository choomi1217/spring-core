package cho.mi.springcore3.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId());
        assertEquals(findMember, savedMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        assertEquals(memberRepository.findAll().size(), 2);
    }

}
