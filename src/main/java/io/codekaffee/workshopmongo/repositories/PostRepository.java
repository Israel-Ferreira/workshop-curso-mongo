package io.codekaffee.workshopmongo.repositories;

import io.codekaffee.workshopmongo.domain.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {
}
