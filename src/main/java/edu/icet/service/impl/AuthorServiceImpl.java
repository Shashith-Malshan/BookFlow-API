package edu.icet.service.impl;

import edu.icet.repository.AuthorRepository;
import edu.icet.service.AuthorService;
import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.AuthorDTO;
import edu.icet.model.entity.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    private Author toEntity(AuthorDTO authorDTO){
        Author author=new Author();
        author.setName(authorDTO.getName());
        author.setCountry(authorDTO.getCountry());
        return author;
    }
    private AuthorDTO toDTO(Author author){
        AuthorDTO authorDTO=new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setCountry(author.getCountry());
        return  authorDTO;
    }

    @Override
    public void save(AuthorDTO authorDTO) {
        authorRepository.save(toEntity(authorDTO));

    }

    @Override
    public AuthorDTO findById(Long id) {
        Optional<Author> author= authorRepository.findById(id);
        return toDTO(author.get());
    }


}
