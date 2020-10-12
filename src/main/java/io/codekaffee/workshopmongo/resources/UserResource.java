package io.codekaffee.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
