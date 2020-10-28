package io.codekaffee.workshopmongo.dto;

import io.codekaffee.workshopmongo.domain.Post;
import java.time.LocalDate;

public class PostDTO {
    private String id;

    private String title;
    private String body;
    private LocalDate date;

    private UserDTO author;

    public PostDTO(Post post){
        this.id =  post.getId();
        this.title = post.getTitle();

        this.body = post.getBody();
        this.date = post.getDate();
    }

    public PostDTO(String id, String title, String body, LocalDate date, UserDTO author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }
}
