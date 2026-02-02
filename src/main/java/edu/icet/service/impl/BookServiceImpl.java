package edu.icet.service.impl;

import edu.icet.model.dto.BookDTO;
import edu.icet.model.entity.Author;
import edu.icet.model.entity.Book;
import edu.icet.repository.AuthorRepository;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;

    @Override
    public void save(BookDTO bookDTO) {
        bookRepository.save(toEntity(bookDTO));

    }

    private Book toEntity(BookDTO bookDTO){
        Book book=new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());

        Optional<Author> author=authorRepository.findById(bookDTO.getAuthorId());
        book.setAuthor(author.get());
        return book;
    }
}
