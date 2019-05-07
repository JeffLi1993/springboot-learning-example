package demo.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.springboot.WebApplication;
import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(bookController)
                //.addFilters(new CORSFilter())
                .build();
    }


    @Test
    public void getBookList() throws Exception {
        mockMvc.perform(get("/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)));

    }


    @Test
    public void test_create_book_success() throws Exception {

        Book book = createOneBook();

        when(bookService.insertByBook(book)).thenReturn(book);

        mockMvc.perform(
                post("/book/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(book)))

                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("/book/1")));
    }


    @Test
    public void test_create_book_fail_404_not_found() throws Exception {

        Book book = new Book(99L, "conflict");

        when(bookService.exists(book)).thenReturn(true);

        mockMvc.perform(
                post("/book/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(book)))
                .andExpect(status().isConflict());
    }

    @Test
    public void test_get_book_success() throws Exception {

        Book book = new Book(1L, "测试获取一本书", "strongant作者", "社区 www.spring4all.com 出版社出版");

        when(bookService.findById(1L)).thenReturn(book);

        mockMvc.perform(get("/book/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("测试获取一本书")));

        verify(bookService, times(1)).findById(1L);
        verifyNoMoreInteractions(bookService);
    }

    @Test
    public void test_get_by_id_fail_null_not_found() throws Exception {
        when(bookService.findById(1L)).thenReturn(null);

        //TODO: 查找不到应该抛出 404 状态码， Demo 待优化
        mockMvc.perform(get("/book/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(bookService, times(1)).findById(1L);
        verifyNoMoreInteractions(bookService);
    }

    @Test
    public void test_update_book_success() throws Exception {

        Book book = createOneBook();

        when(bookService.findById(book.getId())).thenReturn(book);
        doReturn(book).when(bookService).update(book);

        mockMvc.perform(
                put("/book/update", book)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(book)))
                .andExpect(status().isOk());
    }

    @Test
    public void test_update_book_fail_not_found() throws Exception {
        Book book = new Book(999L, "测试书名1");

        when(bookService.findById(book.getId())).thenReturn(null);

        mockMvc.perform(
                put("/book/update", book)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(book)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // =========================================== Delete Book ============================================

    @Test
    public void test_delete_book_success() throws Exception {

        Book book = new Book(1L, "这本书会被删除啦");

        when(bookService.findById(book.getId())).thenReturn(book);
        doReturn(book).when(bookService).delete(book.getId());

        mockMvc.perform(
                delete("/book/delete/{id}", book.getId())
        ).andExpect(status().isOk());
    }

    @Test
    public void test_delete_book_fail_404_not_found() throws Exception {
        Book book = new Book(1L, "这本书会被删除啦");

        when(bookService.findById(book.getId())).thenReturn(null);

        mockMvc.perform(
                delete("/book/delete/{id}", book.getId()))
                .andExpect(status().isOk());
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Book createOneBook() {
        Book book = new Book();
        book.setId(1L);
        book.setName("测试书名1");
        book.setIntroduction("这是一本 www.spring4all.com 社区出版的很不错的一本书籍");
        book.setWriter("strongant");
        return book;
    }
}