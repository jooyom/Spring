/*
package com.example.study15;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@Controller
public class userController {
    @GetMapping("/user")
    public String user(Model model){
        User joo = new User("JooYoung", "908joo@gmail.com", true);
        model.addAttribute("username", joo.getUsername());
        model.addAttribute("email", joo.getEmail());
        model.addAttribute("admin", joo.isAdmin());
        return("/user");
    }

    @GetMapping("/user2")
    public String user2(Model model){
        User bsk = new User("berserker", "berserker@gmail.com", false);
        model.addAttribute("username", bsk.getUsername());
        model.addAttribute("email", bsk.getEmail());
        model.addAttribute("admin", bsk.isAdmin());
        return("/user2");
    }
}
*/
