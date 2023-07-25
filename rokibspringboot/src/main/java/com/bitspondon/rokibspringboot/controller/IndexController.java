package com.bitspondon.rokibspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {




    @GetMapping( {"/","/home","/index"})
    public String index(){

        return "index";
    }


}


