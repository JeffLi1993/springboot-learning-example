package demo.springboot.domain;

import java.io.Serializable;

/**
 * Book 实体类
 *
 * Created by bysocket on 27/09/2017.
 */
public class Book implements Serializable {

    /**
     * 编号
     */
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String writer;

    /**
     * 简介
     */
    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Book(Long id, String name, String writer, String introduction) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.introduction = introduction;
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}
