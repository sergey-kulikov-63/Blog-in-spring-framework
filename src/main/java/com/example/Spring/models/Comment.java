package com.example.Spring.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    private String user_name;
    private String comment_text;
    private String user_email;
    private LocalDate comment_date;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_date() {
        return comment_date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }

    public void setComment_date(LocalDate comment_date) {
        this.comment_date = comment_date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment(String user_name, String comment_text, String user_email, LocalDate comment_date, Post post) {
        this.user_name = user_name;
        this.comment_text = comment_text;
        this.user_email = user_email;
        this.comment_date = comment_date;
        this.post = post;
    }

    public Comment() {
    }
}
