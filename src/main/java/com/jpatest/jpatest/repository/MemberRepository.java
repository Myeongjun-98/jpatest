package com.jpatest.jpatest.repository;

import com.jpatest.jpatest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> { // 이게 있어야 매퍼 대신으로함. <엔티티, 아이디(프라이머리키)타입>
    public Member findByMemberIdAndPassword(String memberId, String password);



}
