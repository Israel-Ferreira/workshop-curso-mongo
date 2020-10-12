package io.codekaffee.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import io.codekaffee.workshopmongo.domain.User;
import io.codekaffee.workshopmongo.repositories.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();

        User user1 = new User("Israel", "israelfsouza@example.com");
        User user2 = new User("Denilson", "denilson@example.com");
        User user3 = new User("Mariana", "mariana@example.com");
        repo.saveAll(Arrays.asList(user1, user2, user3));

    }
    
}
