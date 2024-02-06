package com.example.SeminarHomework7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

//    @GetMapping("/index")
//    public String index() {
//        return "redirect:/";
//    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

}
