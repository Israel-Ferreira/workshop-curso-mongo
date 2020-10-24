package io.codekaffee.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codekaffee.workshopmongo.domain.User;
import io.codekaffee.workshopmongo.exceptions.ObjectNotFoundException;
import io.codekaffee.workshopmongo.repositories.UserRepository;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        var users = userRepository.findAll();
        return users;
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> this.notFoundException());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updatUser(String id, User update) {
        return userRepository.findById(id).map(user -> {
            user.setName(update.getName());
            user.setEmail(update.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() ->  this.notFoundException());
    }


    private ObjectNotFoundException notFoundException(){
        return new ObjectNotFoundException("Objeto Não encontrado");
    }

}
