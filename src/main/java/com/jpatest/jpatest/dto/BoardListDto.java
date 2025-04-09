package com.jpatest.jpatest.dto;

import com.jpatest.jpatest.entity.Board;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Getter
@Setter
public class BoardListDto {
    private int id;
    private String title;
    private String memberId;
    private int hit;
    private LocalDate writeDate;

    public static ModelMapper modelMapper = new ModelMapper();

    public static BoardListDto from(Board board){
        return modelMapper.map(board, BoardListDto.class);  // ( 출발지, 목적지 )
    }
}
