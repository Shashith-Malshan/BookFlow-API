package edu.icet.service;

import edu.icet.model.dto.BookDTO;
import org.springframework.stereotype.Service;


public interface BookService {
    void save(BookDTO bookDTO);
}
