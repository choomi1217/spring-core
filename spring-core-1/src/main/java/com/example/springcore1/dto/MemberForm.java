package com.example.springcore1.dto;

import com.example.springcore1.domain.Member;

public class MemberForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member toMember() {
        return new Member(name);
    }
}
