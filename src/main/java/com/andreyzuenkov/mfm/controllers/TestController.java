package com.andreyzuenkov.mfm.controllers;

import com.andreyzuenkov.mfm.domain.Message;
import com.andreyzuenkov.mfm.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private MessageRepo messageRepo;


    @GetMapping("/main")
    public String main(Model model) {

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Model model) {

        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }


    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Model model){
        Iterable<Message> messages;
        if(filter !=null && !filter.isEmpty()) {
            messages=messageRepo.findByTag(filter);
        }
        else {
            messages=messageRepo.findAll();
        }
        model.addAttribute("messages", messages);

        return "main";
    }
}
