package edu.icet.controller;

import edu.icet.model.entity.Author;
import edu.icet.service.AuthorService;
import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.AuthorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("authorInfo")
public class AuthorController {

    final AuthorService authorService;

    @PostMapping
    public void addAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.save(authorDTO);
    }
    
    @GetMapping("{id}")
    public AuthorDTO getAuthor(@PathVariable Long id){
        return authorService.findById(id);
    }


}
