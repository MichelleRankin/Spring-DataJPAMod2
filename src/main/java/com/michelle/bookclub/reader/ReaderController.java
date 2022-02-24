package com.michelle.bookclub.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class ReaderController {

    @Autowired
    ReaderRepository readerRepository;

    @GetMapping
    List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    @PostMapping
    Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}