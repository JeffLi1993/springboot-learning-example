package demo.springboot.service;

import demo.springboot.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Book 业务接口层
 *
 * Created by bysocket
 */
public interface BookService {
    /**
     * 获取所有 Book
     */
    Flux<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Mono<Book> insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Mono<Book> update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    Mono<Void> delete(Long id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Mono<Book> findById(Long id);
}
