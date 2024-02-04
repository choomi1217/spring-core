package com.example.springcore1.repository;

import com.example.springcore1.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long memberId);

    Optional<Member> findByName(String name);

    List<Member> findAll();

    void clearStore();
}
