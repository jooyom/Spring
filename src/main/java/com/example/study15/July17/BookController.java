package com.example.study15.July17;

import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final PathMatcher mvcPathMatcher;
    private List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public BookController(PathMatcher mvcPathMatcher) {
        this.mvcPathMatcher = mvcPathMatcher;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        Book books1 = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException());
        return books1;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book updateBook){
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setIsbn(updateBook.getIsbn());
        book.setPrice(updateBook.getPrice());
        book.setPublishedYear(updateBook.getPublishedYear());
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id){
        books.removeIf(b -> b.getId() == id);
    }
}
