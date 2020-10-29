package io.codekaffee.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.domain.User;
import io.codekaffee.workshopmongo.dto.UserDTO;
import io.codekaffee.workshopmongo.exceptions.ObjectNotFoundException;
import io.codekaffee.workshopmongo.repositories.UserRepository;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired 
    private PostService postService;

    public List<User> findAll() {
        var users = userRepository.findAll();
        return users;
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> this.notFoundException());
    }


    public User createUserPost(String id, Post post){
        User user = this.getUserById(id);
        Post userPost = postService.create(post);

        user.getPosts().add(userPost);

        return userRepository.save(user);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User createUserFromDTO(UserDTO userDTO){
        User user = this.fromDto(userDTO);
        return this.createUser(user);
    }

    public User fromDto(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getEmail());
    }

    public User update(String id, UserDTO updateDto) {
        var update = this.fromDto(updateDto);
        
        return userRepository.findById(id).map(user -> {
            this.updateData(user, update);
            return userRepository.save(user);
        }).orElseThrow(() ->  this.notFoundException());
    }


    private void updateData(User obj, User newObj){
        obj.setName(newObj.getName());
        obj.setEmail(newObj.getEmail());
    }

    public void delete(String id){
        this.getUserById(id);

        userRepository.deleteById(id);
    }




    private ObjectNotFoundException notFoundException(){
        return new ObjectNotFoundException("Objeto Não encontrado");
    }

}
