package com.example.Spring.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id;
    private String post_title;
    private String post_anons;
    private String post_text;
    private LocalDate post_date;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments; // содержит список комментариев к посту

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_anons() {
        return post_anons;
    }

    public void setPost_anons(String post_anons) {
        this.post_anons = post_anons;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public String getPost_date() {
        return post_date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    } // геттер, который возвращает дату в нужном формате

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post() {
    }

    public Post(String post_title, String post_anons, String post_text,
                LocalDate post_date) {
        this.post_title = post_title;
        this.post_anons = post_anons;
        this.post_text = post_text;
        this.post_date = post_date;
    }
}
