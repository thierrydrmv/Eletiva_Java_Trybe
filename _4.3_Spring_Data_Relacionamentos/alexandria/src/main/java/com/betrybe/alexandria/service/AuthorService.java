package com.betrybe.alexandria.service;

import com.betrybe.alexandria.models.entities.Author;
import com.betrybe.alexandria.models.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author insertAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> updateAuthor(Long id, Author author) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if(authorOptional.isPresent()) {
            Author authorFromDB = authorOptional.get();
            authorFromDB.setName(author.getName());
            authorFromDB.setNationality(author.getNationality());

            Author updatedAuthor = authorRepository.save(authorFromDB);
            return Optional.of(updatedAuthor);
        }

        return authorOptional;
    }

    public Optional<Author> removeAuthorById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if(authorOptional.isPresent()) {
            authorRepository.deleteById(id);
        }

        return authorOptional;
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
