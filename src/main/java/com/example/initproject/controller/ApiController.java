package com.example.initproject.controller;

import com.example.initproject.model.Slime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("slimeLand")
    @ResponseBody
    public Slime slimeApi(@RequestParam("input_data") String input_data) {
        Slime slime = new Slime();
        slime.setName(input_data);
        return slime;
    }

}
