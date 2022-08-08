package com.example.initproject.controller;

import com.example.initproject.domain.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("slimeLand")
    @ResponseBody
    public Board slimeApi(@RequestParam("input_data") String input_data) {
        Board board = new Board();
        board.setTitle(input_data);
        return board;
    }

}
