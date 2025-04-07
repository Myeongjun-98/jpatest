package com.jpatest.jpatest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;	// member테이블 번호
    private String memberId;	// 아이디
    private String password;	// 비밀번호
    private String name;	// 이름
    private String email;	// 이메일
    private String tel;	// 연락처

}
/*
    @Column( name = "user_id" )
    @Column( length = 50 ) varchar(50)설정
    @Column( nullable = false ) null을 허용하지 않는다
*/