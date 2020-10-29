package io.codekaffee.workshopmongo.services;

import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.exceptions.ObjectNotFoundException;
import io.codekaffee.workshopmongo.repositories.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostService implements  ICrudService<Post> {
    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(ObjectId id) {
        System.out.println(id);
        return postRepository.findById(id).orElseThrow(this::objectNotFoundException);
    }

    public Post create(Post obj) {
        return postRepository.save(obj);
    }

    @Override
    public Post update(ObjectId id, Post obj) {
        return this.postRepository.findById(id).map(post -> {
            post.setTitle(obj.getTitle());
            post.setBody(obj.getBody());
            post.setDate(obj.getDate());
            
            post.setAuthor(obj.getAuthor());
            post.setComments(obj.getComments());

            return postRepository.save(post);
        }).orElseThrow(this::objectNotFoundException);
    }

    @Override
    public void delete(ObjectId id) {
        this.postRepository.deleteById(id);
    }


    public List<Post> searchByTitle(String title){
        return this.postRepository.findByTitleQuery(title);
    }


    @Override
    public ObjectNotFoundException objectNotFoundException() {
        return new ObjectNotFoundException("Post não encontrado");
    }
}
