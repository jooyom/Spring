package com.example.study15;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public String list(Model model){
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/new")
    public String newBookForm(Model model){
        return "book/form";
    }

    @PostMapping
    public String saveBook (@ModelAttribute Book book){
        book.setId(nextId++); //iD를 증가시키는 이유는 Id 값이 유일한 pk이기때문
        books.add(book); //posts 리스트에 post 객체 추가
        return "redirect:/books"; //300번대?
    }



    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model){

        Book book = books.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException());

        model.addAttribute("book", book);
        return "book/detail";
    }

}
