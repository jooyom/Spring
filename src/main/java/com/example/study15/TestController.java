package com.example.study15;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @GetMapping("/index")
    public String test(Model model){
        model.addAttribute("message", "Hello! Thymeleaf!");
        return "index";
    }


    @PostMapping("/forms")
    public String forms (@ModelAttribute User user){
        System.out.println("유저의 비밀번호는 " + user.getPassword() + " 입니다");

        return "forms";
    }
}
