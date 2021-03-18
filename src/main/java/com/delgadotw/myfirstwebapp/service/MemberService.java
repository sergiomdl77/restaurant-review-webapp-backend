package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.MemberRepository;
import com.delgadotw.myfirstwebapp.exception.MemberNotFoundException;
import com.delgadotw.myfirstwebapp.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService
{
    private final MemberRepository memberRepository;

    @Autowired       //  Annotation used for the MemberRepository dependency injection into our MemberService.
    // not necessary when there is only one constructor, but still a good practice to be explicit
    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }

    // Service method that deletes a record from the entity
    public void deleteMemberById(String memId)
    {
        memberRepository.deleteById(memId);
    }

    // Service Method that add a record to the entity and return the added record
    public Member addMember(Member member)
    {
        return memberRepository.saveAndFlush(member);
    }

    public Member updateMember(Member member)
    {
        return memberRepository.save(member);
    }

    public Member findMemberById(String id)
    {
        return memberRepository.findById(id).orElseThrow(
                () -> new MemberNotFoundException("Member by id " + id + " was not found."));
    }

}