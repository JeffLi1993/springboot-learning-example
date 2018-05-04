package demo.springboot.service.impl;

import demo.springboot.dao.BookRepository;
import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Book 业务层实现
 *
 * Created by bysocket
 */
@Component
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public Mono<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
