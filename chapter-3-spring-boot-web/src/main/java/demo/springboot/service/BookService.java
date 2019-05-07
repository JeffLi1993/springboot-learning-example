package demo.springboot.service;

import demo.springboot.domain.Book;

import java.util.List;

/**
 * Book 业务接口层
 *
 * Created by bysocket on 27/09/2017.
 */
public interface BookService {
    /**
     * 获取所有 Book
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Book update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    Book delete(Long id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Book findById(Long id);

    /**
     * 查找书是否存在
     * @param book
     * @return
     */
    boolean exists(Book book);

    /**
     * 根据书名获取书籍
     * @param name
     * @return
     */
    Book findByName(String name);
}
