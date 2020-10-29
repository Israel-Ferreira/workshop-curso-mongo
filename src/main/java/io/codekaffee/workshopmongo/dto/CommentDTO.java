package io.codekaffee.workshopmongo.dto;

import java.time.LocalDate;

public class CommentDTO {
    private String text;
    private AuthorDTO author;
    private LocalDate date;

    public CommentDTO(){}


    public CommentDTO(String text, AuthorDTO author, LocalDate date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
