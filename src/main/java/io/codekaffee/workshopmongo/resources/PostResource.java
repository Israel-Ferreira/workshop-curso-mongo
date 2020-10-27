package io.codekaffee.workshopmongo.resources;

import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        List<Post> posts =  this.postService.findAll();
        return  ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody Post post){
        var postObj =  this.postService.create(post);
        System.out.println(post.getId());

        URI uri =  getPostUrl(postObj);
        return ResponseEntity.created(uri).build();
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




    private URI getPostUrl(Post post){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();
    }
}
