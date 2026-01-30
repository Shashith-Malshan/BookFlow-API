package edu.icet.service.impl;

import edu.icet.model.dto.BookDTO;
import edu.icet.model.entity.Book;
import edu.icet.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save(BookDTO bookDTO) {

    }

    private Book toEntity(BookDTO bookDTO){
        Book book=new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        //book.setAuthor(bookDTO.getAuthorId());

        return book;
    }
}
