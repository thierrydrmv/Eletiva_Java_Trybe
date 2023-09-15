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
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping()
    public List<BookDTO> getAllBooks(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "20") int pageSize
    ) {
        return bookService.getAllBooks(pageNumber, pageSize);
    }

    @PostMapping("/{bookId}/details")
    public ResponseEntity<ResponseDTO<BookDetail>> createBookDetail(@PathVariable Long bookId, @RequestBody BookDetailDto bookDetailDto) {
        Optional<BookDetail> newBookDetail = bookService.insertBookDetail(bookId, bookDetailDto.toBookDetail());
        ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro adicionados com sucesso", newBookDetail.get());
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

    @PutMapping("/{bookId}/publisher/{publisherId}")
    public ResponseEntity<ResponseDTO<Book>> setPublisherFromBook(@PathVariable Long bookId, @PathVariable Long publisherId) {
        Optional<Book> optionalBook = bookService.setPublisher(bookId, publisherId);

        if(optionalBook.isEmpty()) {
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                    String.format("Não foi encontrado o livro de ID %d ou a editora de ID %d", bookId, publisherId), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                "Editora vinculada ao livro com sucesso!", optionalBook.get());
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{bookId}/publisher")
    public ResponseEntity<ResponseDTO<Book>> removePublisherFromBook(@PathVariable Long bookId) {
        Optional<Book> optionalBook = bookService.removePublisher(bookId);
        if(optionalBook.isEmpty()){
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                    String.format("Não foi possível remover a editora do livro com id %d", bookId),
                    null
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>(
                String.format("Editora removida do livro de ID %d", bookId),
                optionalBook.get()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @PutMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<ResponseDTO<Book>> setAuthor(@PathVariable Long bookId, @PathVariable Long authorId){
        Optional<Book> optionalBook = bookService.setAuthor(bookId, authorId);
        if (optionalBook.isEmpty()){
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(String.format("Não foi possível associar um livro de id %d com a pessoa autora de id %d", bookId, authorId), null);
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>("Pessoa autora associada com sucesso:", optionalBook.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<ResponseDTO<Book>> removeAuthor(@PathVariable Long bookId, @PathVariable Long authorId){
        Optional<Book> optionalBook = bookService.removeAuthor(bookId, authorId);
        if (optionalBook.isEmpty()){
            ResponseDTO<Book> responseDTO = new ResponseDTO<>(String.format("Não foi possível remover a associação de id %d com a pessoa autora de id %d", bookId, authorId), null);
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Book> responseDTO = new ResponseDTO<>("Pessoa autora desassociada com sucesso:", optionalBook.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
