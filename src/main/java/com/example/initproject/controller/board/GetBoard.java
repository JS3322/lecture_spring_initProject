package com.example.initproject.controller.board;

import com.example.initproject.domain.Board;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class GetBoard {

    public static Model getBoard(String seq, ArrayList<Board> board_array, Model model) {
        for(int i=0; i<board_array.size(); i++) {
                if(seq.equals(board_array.get(i).getSeq()))
                    model.addAttribute("seq", board_array.get(i).getSeq());
                    model.addAttribute("title", board_array.get(i).getTitle());
                    model.addAttribute("writer", board_array.get(i).getWriter());
                    model.addAttribute("content", board_array.get(i).getContent());
                    model.addAttribute("createDate", board_array.get(i).getCreateDate());
                    model.addAttribute("cnt", board_array.get(i).getCnt());
            }
        return model;
    }
}
