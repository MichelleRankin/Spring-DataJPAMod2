package com.michelle.bookclub.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}
