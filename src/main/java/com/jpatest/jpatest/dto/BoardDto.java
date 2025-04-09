package com.jpatest.jpatest.dto;

import com.jpatest.jpatest.entity.Board;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BoardDto {
    private int id;
    private String memberId;
    private String title;
    private String content;
    private String fileName;
    private LocalDate writeDate;
    private int hit;
    private List<CommentDto> commentList;

    public static ModelMapper  modelMapper = new ModelMapper();

    public static BoardDto of(Board board, List<CommentDto> commentList){
        BoardDto boardDto = modelMapper.map(board, BoardDto.class);
        boardDto.setCommentList(commentList);
        return boardDto;
    }
}
