package com.jpatest.jpatest.repository;

import com.jpatest.jpatest.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> { // JpaRepository<엔티티, 프라이머리키의 타입(클래스명)>

    public List<Board> findAllByOrderByIdDesc(Pageable pageable);




}

/* jpa 사용 시 메서드이름 짓는 법

기본적으로 제공하는 메서드는
save (insert into)
delete (delete)
findxxxx (select)

update는 없음, update는 엔티티 값을 바꿔주는 식으로 진행....

//////////쿼리문//////////
    쿼리문 - select * from board
    메서드 - findAll() : 테이블 전체의 레코드 가져오기 ( 정렬, 페이징 가능 )

    쿼리문 - select count(*) from board   
    메서드 - count() : 테이블 전체 레코드 개수 가져오기
    
    쿼리문 - select * from board where id=4
    메서드 - findById(4) : primary key인 컬럼으로 조회한다.
 
    쿼리문 - select * from board where member_id = 'mjk123'
    메서드 - findByMemberId("mjk123") : 테이블에서 member_id 조건으로 조회
 
    쿼리문 - select * from board where title = "가나다" And hit = 10
    메서드 - findByTitleAndHit("가나다", 10)

    쿼리문 - select * from board where hit = 20 or write_date = 2025-04-04
    메서드 - findByHitOrWriteDate(20, "2025-04-04")  따옴표 쓰는지 안쓰는지는 모르겠음

    쿼리문 - select * from board where hit >= 50
    메서드 - findByHitGreaterThanEqual(50)
    쿼리문 - select * from board where hit <= 100
    메서드 - findByHitLessThanEqual(100)

    쿼리문 - select * from board where title like '%가나'
    메서드 - findByTitleLike("%가나")
            findByTitleLike("가%")
            findByTitleLike("%가%")

          % 없이 %가%를 구현하고 싶다면,
            findByTitleContaining(String title)
            findByTitleStartingWith - "가%"
            findByTitleEndingWith   - "%가"



    쿼리문 - select * from board order by id desc
    메서드 - findByOrderByIdDesc

    쿼리문 - select * from board order by id desc limit 0, 10
    메서드 - findTop10ByOrderByIdDesc
        ->  id컬럼 기준으로 내림차순 정렬하고 최대 10개 조회
        - findAllByOrderByIdDesc( Pageable )


        @Query( value = " select * from board order by id desc limit 0, 10"
                            nativeQuery = true)
        boardList()

    쿼리문 - select * from board where hit between 10 and 100;
    메서드 - findByHitBetween(10, 100)


    조인 - select * from board b join user u on b.member_id = u.user_id
            where u.user_id = 'jkr123'
    엔티티 연관 관계 기반 조인 가능  @OneToOne, @OneToMany, @ManyToOne, @ManyToMany  **엔티티클래스에 해야함**

    메서드 - findByMemberIdUserId("jkr123")    (left테이블이 되는 board테이블(엔티티)에 만듦)










*/
