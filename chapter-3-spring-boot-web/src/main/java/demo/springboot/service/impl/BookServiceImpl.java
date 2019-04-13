package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import demo.springboot.web.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Book 业务层实现
 * <p>
 * Created by bysocket on 27/09/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    private static final AtomicLong counter = new AtomicLong();


    /**
     * 使用集合模拟数据库
     */
    private static List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book(counter.incrementAndGet(), "book")));


    // 模拟数据库，存储 Book 信息
    // 第五章《﻿数据存储》会替换成 MySQL 存储
    private static Map<String, Book> BOOK_DB = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId().toString(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        BOOK_DB.put(book.getId().toString(), book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        return BOOK_DB.remove(id.toString());
    }

    @Override
    public Book findById(Long id) {
        return BOOK_DB.get(id.toString());
    }

    @Override
    public boolean exists(Book book) {
        return findByName(book.getName()) != null;
    }

    @Override
    public Book findByName(String name) {

        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }

        return null;
    }
}
