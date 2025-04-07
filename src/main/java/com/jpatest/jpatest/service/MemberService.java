package com.jpatest.jpatest.service;

import com.jpatest.jpatest.dto.MemberDto;
import com.jpatest.jpatest.entity.Member;
import com.jpatest.jpatest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void insert(MemberDto memberDto) {
//      쿼리문을 만들지 않아도 이렇게..
        Member member = memberDto.createMember();
//      레포지토리에 만들지 않아도 쿼리문이 존재..!!!
        memberRepository.save(member);
    }

    public boolean select(MemberDto memberDto){

        Member member = memberRepository.findByMemberIdAndPassword(
                memberDto.getMemberId(), memberDto.getPassword()
        );
        if(member == null){
            return false;
        }return true;

    }

}
