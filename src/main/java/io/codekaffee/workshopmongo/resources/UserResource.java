package io.codekaffee.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.codekaffee.workshopmongo.domain.User;
import io.codekaffee.workshopmongo.dto.PostDTO;
import io.codekaffee.workshopmongo.dto.UserDTO;
import io.codekaffee.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();

        List<UserDTO> usersDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDTOs);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = userService.createUserFromDTO(userDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") String id) {
        User user = userService.getUserById(id);

        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok().body(userDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") String id, @RequestBody UserDTO user) {
        User newUser = userService.update(id, user);
        UserDTO userDTO = new UserDTO(newUser);
        return ResponseEntity.ok().body(userDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}/user-posts")
    public ResponseEntity<List<PostDTO>> getUserPosts(@PathVariable("id") String id){
        User author = userService.getUserById(id);
        List<PostDTO> posts =  author.getPosts()
            .stream()
            .map(post -> new PostDTO(post))
            .collect(Collectors.toList());

        return ResponseEntity.ok(posts);
    }


}
