package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        System.out.println(" call findById method ");
        return bookRepository.findById(id).get();
    }
}
