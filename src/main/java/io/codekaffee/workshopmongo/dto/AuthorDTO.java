package io.codekaffee.workshopmongo.dto;

import io.codekaffee.workshopmongo.domain.User;


public class AuthorDTO {
    private String id;
    private String  name;
    private String email;


    public AuthorDTO(){}

    public AuthorDTO(User author){

        System.out.println(author);
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
