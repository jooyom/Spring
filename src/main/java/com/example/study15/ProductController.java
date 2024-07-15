package com.example.study15;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {

   // private List<product> products = new ArrayList<>();
    /*private Long nextId = 1L;

    @GetMapping
    public String list(Model model){
        model.addAttribute("products", products);
        return "product/list";
    }*/

    @GetMapping("/products")
    public String product(Model model){

        model.addAttribute("watermelonID", "1");
        model.addAttribute("watermelon", "watermelon");
        model.addAttribute("watermelonPrice", "6000");

        model.addAttribute("strawberryID", "2");
        model.addAttribute("strawberry", "strawberry");
        model.addAttribute("strawberryPrice", "3000");

        return "/product";
    }





    /*@GetMapping("/{id}") // 중괄호 !
    public String detail(@PathVariable("id") Long id, Model model){
        //경로 변수
        product product = products.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException());

        model.addAttribute("products", product);
        return "product/detail";
    }*/
}
