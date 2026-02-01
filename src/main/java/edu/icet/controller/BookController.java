package edu.icet.controller;

import edu.icet.model.dto.BookDTO;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookInfo")
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO){
        bookService.save(bookDTO);

    }

}
