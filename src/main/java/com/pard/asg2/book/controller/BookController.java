package com.pard.asg2.book.controller;

import com.pard.asg2.book.dto.BookDto;
import com.pard.asg2.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//정보를 json으로 변환해줌
@RequiredArgsConstructor//생성자 final
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String add(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
        return "저장완료!!";
    }
    @GetMapping("/id/{bookId}")
    public BookDto findByBookId(@PathVariable long bookId){
        return bookService.findByBookId(bookId);
    }
    @GetMapping("/name/{bookName}")
    public BookDto findByBookName(@PathVariable String bookName){
        return bookService.findByBookName(bookName);
    }
    @PatchMapping("/id/{bookId}")
    public String updateByBookId(@PathVariable long bookId, @RequestBody BookDto bookDto){
        bookService.updateByBookId(bookId,bookDto);
        return "id로 해당정보 수정완료";
    }
    @PatchMapping("/name/{BookName}")
    public String updateByBookName(@PathVariable String BookName, @RequestBody BookDto bookDto){
        bookService.updateByBookName(BookName,bookDto);
        return "name으로 해당정보 수정완료";
    }
    @DeleteMapping("/id/{bookId}")
    public String deleteByBookId(@PathVariable long bookId){
        bookService.deleteByBookId(bookId);
        return "입력하신 id로 해당정보 삭제완료!!";
    }
    @DeleteMapping("/name/{bookName}")
    public String deleteByBookName(@PathVariable String bookName){
        bookService.deleteByBookName(bookName);
        return "입력하신 name으로 해당정보 삭제완료!!";
    }
    @GetMapping("")
    public List<BookDto> findAll(){
        return bookService.findAll();
    }
}
