package io.codekaffee.workshopmongo.resources;

import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.dto.PostDTO;
import io.codekaffee.workshopmongo.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;


    @GetMapping
    public ResponseEntity<List<PostDTO>> getAll(){
        List<Post> posts =  this.postService.findAll();
        var listPosts = posts.stream().map(PostDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok(listPosts);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") ObjectId id){
        Post post = this.postService.findById(id);
        return  ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable("id") ObjectId id, @RequestBody Post obj){
        var post =  this.postService.update(id, obj);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePost(@PathVariable("id") ObjectId id){
        this.postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
