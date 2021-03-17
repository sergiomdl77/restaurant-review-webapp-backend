package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.MemberRepository;
import com.delgadotw.myfirstwebapp.models.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService
{
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }

}