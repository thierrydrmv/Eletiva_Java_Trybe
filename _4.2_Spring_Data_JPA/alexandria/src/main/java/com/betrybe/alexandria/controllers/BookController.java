package com.betrybe.alexandria.controllers;

import com.betrybe.alexandria.controllers.dto.BookDTO;
import com.betrybe.alexandria.controllers.dto.BookDetailDto;
import com.betrybe.alexandria.controllers.dto.ResponseDTO;
import com.betrybe.alexandria.models.entities.Book;
import com.betrybe.alexandria.models.entities.BookDetail;
import com.betrybe.alexandria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @PostMapping()
    public ResponseEntity<ResponseDTO<Book>> createBook(@RequestBody BookDTO bookDTO) {
        Book newBook = bookService.insertBook(bookDTO.toBook());
        ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro criado com sucesso", newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<ResponseDTO<Book>> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
        Optional<Book> optionalBook = bookService.updateBook(bookId, bookDTO.toBook());

        if (optionalBook.isEmpty()) {
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                    String.format("Não foi encontrado o livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                "Livro atualizado com sucesso!", optionalBook.get());
        return ResponseEntity.ok(responseDTO);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<ResponseDTO<Book>> removeBookById(@PathVariable Long bookId) {
        Optional<Book> optionalBook = bookService.removeBookById(bookId);

        if(optionalBook.isEmpty()) {
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                    String.format("Não foi encontrado o livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }
        ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro removido com sucesso!", null);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseDTO<Book>> getBookById(@PathVariable Long bookId) {
        Optional<Book> optionalBook = bookService.getBookById(bookId);

        if(optionalBook.isEmpty()) {
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                    String.format("Não foi encontrado o livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                "Livro encontrado com sucesso!", optionalBook.get());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping()
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks.stream()
                .map((book) -> new BookDTO(book.getId(), book.getTitle(), book.getGenre()))
                        .collect(Collectors.toList());
    }

    @PostMapping("/{bookId}/details")
    public ResponseEntity<ResponseDTO<BookDetail>> createBookDetail(@RequestBody BookDetailDto bookDetailDto) {
        BookDetail newBookDetail = bookService.insertBookDetail(bookDetailDto.toBookDetail());
        ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro adicionados com sucesso", newBookDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{bookId}/details/{id}")
    public ResponseEntity<ResponseDTO<BookDetail>> updateBookDetail(@PathVariable Long bookId, @RequestBody BookDetailDto bookDetailDto) {
        Optional<BookDetail> optionalBookDetail = bookService.updateBookDetail(bookId, bookDetailDto.toBookDetail());

        if (optionalBookDetail.isEmpty()) {
            ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
                    String.format("Não foram encontrados os detalhes do livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
                "Detalhes do livro atualizados com sucesso!", optionalBookDetail.get());
        return ResponseEntity.ok(responseDTO);
    }
    @DeleteMapping("/{bookId}/details/{id}")
    public ResponseEntity<ResponseDTO<BookDetail>> removeBookDetailById(@PathVariable Long bookId) {
        Optional<BookDetail> optionalBook = bookService.removeBookDetailById(bookId);

        if(optionalBook.isEmpty()) {
            ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
                    String.format("Não foram encontrados os detalhes do livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }
        ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro removidos com sucesso!", null);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{bookId}/details/{id}")
    public ResponseEntity<ResponseDTO<BookDetail>> getBookDetailById(@PathVariable Long bookId) {
        Optional<BookDetail> optionalBook = bookService.getBookDetailById(bookId);

        if(optionalBook.isEmpty()) {
            ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
                    String.format("Não foram encontrados os detalhes livro de ID %d", bookId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
                "Detalhes do livro encontrados com sucesso!", optionalBook.get());
        return ResponseEntity.ok(responseDTO);
    }
}
