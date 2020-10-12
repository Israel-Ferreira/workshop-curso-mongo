package io.codekaffee.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.codekaffee.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
