package demo.springboot.web;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Book 控制层
 *
 * Created by bysocket on 27/09/2017.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {


    private final Logger LOG = LoggerFactory.getLogger(BookController.class);


    @Autowired
    BookService bookService;

    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBookList() {
        return bookService.findAll();
    }

    /**
     * 获取 Book
     * 处理 "/book/{id}" 的 GET 请求，用来获取 Book 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @RequestBody 绑定实体参数，也通过 @RequestParam 传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> postBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {

        LOG.info("creating new book: {}", book);

        if (book.getName().equals("conflict")){
            LOG.info("a book with name " + book.getName() + " already exists");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        bookService.insertByBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Book putBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }

}
