package com.andreyzuenkov.mfm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping
    public String testPage(){

        return "index";
    }
}
