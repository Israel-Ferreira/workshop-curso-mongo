package io.codekaffee.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codekaffee.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = new ArrayList<>();

        User user1 =  new User("Israel", "israelfsouza@example.com");
        User user2 = new User("Denilson", "denilson@example.com");

        users.addAll(Arrays.asList(user1, user2));

        return ResponseEntity.ok().body(users);
    }
}
