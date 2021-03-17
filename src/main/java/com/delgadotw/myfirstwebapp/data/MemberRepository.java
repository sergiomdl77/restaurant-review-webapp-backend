package com.delgadotw.myfirstwebapp.data;

import com.delgadotw.myfirstwebapp.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>
{

}