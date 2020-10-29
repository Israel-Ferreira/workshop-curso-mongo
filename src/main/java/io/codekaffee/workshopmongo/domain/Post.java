package io.codekaffee.workshopmongo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import io.codekaffee.workshopmongo.dto.AuthorDTO;
import io.codekaffee.workshopmongo.dto.CommentDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String title;
    private String body;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;


    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String title, String body, LocalDate date, AuthorDTO author) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public Post(String title, String body, LocalDate date, AuthorDTO author, List<CommentDTO> comments) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
        this.comments = comments;
    }


    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
