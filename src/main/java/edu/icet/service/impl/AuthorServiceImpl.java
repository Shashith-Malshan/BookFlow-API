package edu.icet.service.impl;

import edu.icet.repository.AuthorRepository;
import edu.icet.service.AuthorService;
import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.AuthorDTO;
import edu.icet.model.entity.Author;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    private Author toEntity(AuthorDTO authorDTO){
        Author author=new Author();
        author.setName(authorDTO.getName());
        author.setCountry(authorDTO.getCountry());
        return author;
    }

    @Override
    public void save(AuthorDTO authorDTO) {
        authorRepository.save(toEntity(authorDTO));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }


}
