package com.example.springcore1.repository;

import com.example.springcore1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long memberId);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
