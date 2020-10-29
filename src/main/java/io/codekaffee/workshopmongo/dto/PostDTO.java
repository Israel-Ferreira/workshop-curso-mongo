package io.codekaffee.workshopmongo.dto;

import io.codekaffee.workshopmongo.domain.Post;
import java.time.LocalDate;

public class PostDTO {
    private String id;

    private String title;
    private String body;
    private LocalDate date;

    private AuthorDTO author;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();

        this.body = post.getBody();
        this.date = post.getDate();

        if (post.getAuthor() != null)
            this.author = post.getAuthor();
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
