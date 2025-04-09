package com.jpatest.jpatest.service;

import com.jpatest.jpatest.dto.BoardDto;
import com.jpatest.jpatest.dto.BoardListDto;
import com.jpatest.jpatest.dto.CommentDto;
import com.jpatest.jpatest.entity.Board;
import com.jpatest.jpatest.entity.Comment;
import com.jpatest.jpatest.repository.BoardRepository;
import com.jpatest.jpatest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor    // 파이널로 한 레포지토리의 생성자메서드를 만들기 위해
public class BoardService {

    // @Autowired 또는 lombok의 @RequiredArgsConstructor를 사용하여 주입한다.
    // 주입하기전에 반드시 빈 등록 되어있어야한다.
    // 빈 - @Service, @Repository, @Bean 등등...........................
    private final BoardRepository boardRepository;

    private final CommentRepository commentRepository;

    public BoardDto getBoard(int boardId){
        Board board = boardRepository.findById(boardId).get();

        List<Comment> commentList = commentRepository.findByBoardId(boardId);

        List<CommentDto> commentDtos = new ArrayList<>();
        for(Comment comment : commentList){
            CommentDto commentDto = CommentDto.from(comment);
            commentDtos.add(commentDto);
        }

        BoardDto boardDto = BoardDto.of(board, commentDtos);
        return boardDto;
    }

    // 게시글 10개 가져와서 목록 출력하기 위한 메서드
    public Page<BoardListDto> getBoardList(Pageable pageable){
        List<BoardListDto> boardListDtos = new ArrayList<>();

        // 레포지토리를 통해 테이블에서 조회하기 - pageable을 이용하여 10개 가져오기
        // pageable 값 설정은 Control에서 한다.
        List<Board> boards = boardRepository.findAllByOrderByIdDesc(pageable);

        // 전체게시글 개수
        Long total = boardRepository.count();   // 카운트의 반환타입이 Long이라서 Long으로 항상 해야댐
                                                // Long으로 해도, long으로 해도 괜찮음
        // entity -> dto
        for(Board board : boards){
            BoardListDto boardListDto = BoardListDto.from(board);
            boardListDtos.add(boardListDto);
        }

        return new PageImpl<>(boardListDtos, pageable, total);
    }


}
