package com.delgadotw.myfirstwebapp.controllers;


import com.delgadotw.myfirstwebapp.models.Member;
import com.delgadotw.myfirstwebapp.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberRestController
{
    private final MemberService memberService;

    public MemberRestController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
}