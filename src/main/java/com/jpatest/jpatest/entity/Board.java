package com.jpatest.jpatest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="board")    // 데이터베이스의 실제 테이블 이름 (테이블 이름이 실제 이름과 다를 때 이렇게 함)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String member_id;
    private String content;
    private String fileName;
    private int hit;
    private LocalDate writeDate;
    


}

// @Column(unique = true) 유일값으로 설정하고 싶을 때 (??? 용법을 잘 모르겠음)