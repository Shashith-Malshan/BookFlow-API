package edu.icet.service;

import edu.icet.model.dto.AuthorDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    void save(AuthorDTO authorDTO);

    AuthorDTO findById(Long id);
}
