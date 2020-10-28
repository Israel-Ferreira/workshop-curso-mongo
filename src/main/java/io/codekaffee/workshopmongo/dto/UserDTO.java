package io.codekaffee.workshopmongo.dto;

import java.io.Serializable;
import java.util.List;
import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.domain.User;

public class UserDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String email;

    private List<Post> posts;

    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.posts = user.getPosts();
    }

    public UserDTO(String id, String name, String email){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
