package edu.icet.service;

import edu.icet.model.dto.AuthorDTO;
import edu.icet.model.entity.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthorService {
    void save(AuthorDTO authorDTO);

    Optional<Author> findById(Long id);
}
