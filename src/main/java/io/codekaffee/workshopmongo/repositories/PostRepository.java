package io.codekaffee.workshopmongo.repositories;

import io.codekaffee.workshopmongo.domain.Post;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {

    @Query("{'title': {$regex: ?0, $options: 'i' }}")
    List<Post> findByTitleQuery(String title);


    List<Post> findByTitleContaining(String title);
}
