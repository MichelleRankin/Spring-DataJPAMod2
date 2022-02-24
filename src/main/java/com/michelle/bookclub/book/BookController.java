package com.michelle.bookclub.book;

import com.michelle.bookclub.reader.Reader;
import com.michelle.bookclub.reader.ReaderRepository;
import com.michelle.bookclub.author.Author;
import com.michelle.bookclub.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{bookId}/reader/{readerId}")
    Book addReaderToBook(
            @PathVariable Long bookId,
            @PathVariable Long readerId
    ) {
        Book book = bookRepository.findById(bookId).get();
        Reader reader = readerRepository.findById(readerId).get();
        book.enrolledReaders.add(reader);
        return bookRepository.save(book);
    }

    @PutMapping("/{bookId}/author/{authorId}")
    Book assignAuthorToBook(
            @PathVariable Long bookId,
            @PathVariable Long authorId
    ) {
        Book book = bookRepository.findById(bookId).get();
        Author author = authorRepository.findById(authorId).get();
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
