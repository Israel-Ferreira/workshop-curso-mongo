package io.codekaffee.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.codekaffee.workshopmongo.domain.User;
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

        List<UserDTO> usersDTOs = users.stream()
            .map(user-> new UserDTO(user))
            .collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDTOs);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user =  userService.createUserFromDTO(userDTO);


        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();



        return  ResponseEntity.created(uri).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") String id){
        User user  = userService.getUserById(id);

        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok().body(userDTO);

    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") String id, @RequestBody UserDTO user){
        User newUser = userService.update(id, user);
        UserDTO userDTO = new UserDTO(newUser);
        return ResponseEntity.ok().body(userDTO);
    
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
