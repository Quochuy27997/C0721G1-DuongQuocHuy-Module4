package com.codegym.blog.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String title;
    @Column(length = 500)
    private String head;
    @Column(length = 5000)
    private String body;
   @ManyToOne(targetEntity = Category.class,cascade = CascadeType.MERGE)
   @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
   private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blog(String title, String head, String body, Category category, Date date) {
        this.title = title;
        this.head = head;
        this.body = body;
        this.category = category;
        this.date = date;
    }

    public Blog(String title, String head, String body, Category category) {
        this.title = title;
        this.head = head;
        this.body = body;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Blog( String title, String head, String body) {
        this.title = title;
        this.head = head;
        this.body = body;
    }

    public Blog() {
    }



}
