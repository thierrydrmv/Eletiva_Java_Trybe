package com.betrybe.alexandria.models.repositories;

import com.betrybe.alexandria.models.entities.Author;
import com.betrybe.alexandria.models.entities.Book;
import com.betrybe.alexandria.models.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);
    Optional<Book> findByPublisher(Publisher publisher);
    List<Book> findBooksByAuthors(Author author);
}
