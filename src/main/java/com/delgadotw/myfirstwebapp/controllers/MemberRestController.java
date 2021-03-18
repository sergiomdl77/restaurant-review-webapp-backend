package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.models.Member;
import com.delgadotw.myfirstwebapp.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
   Class that makes the connection between the client and the endpoint.
   It is in charge of mapping the client's requests to the appropriate
   web services to expose the data from the Database.
 */

@RestController
@RequestMapping("/api/member")
public class MemberRestController
{
    private final MemberService memberService;

    public MemberRestController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Member>> getAllMembers()
    {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") String id)
    {
        Member member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member)
    {
        Member newMember = memberService.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member)
    {
        Member updatedMember = memberService.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.CREATED);
    }

    // This method won't return the member that was deleted
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") String id)
    {
        memberService.deleteMemberById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}