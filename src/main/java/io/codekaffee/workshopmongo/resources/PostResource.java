package io.codekaffee.workshopmongo.resources;

import io.codekaffee.workshopmongo.domain.Post;
import io.codekaffee.workshopmongo.domain.User;
import io.codekaffee.workshopmongo.dto.PostDTO;
import io.codekaffee.workshopmongo.repositories.UserRepository;
import io.codekaffee.workshopmongo.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @Autowired 
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPost(@RequestBody Post newPost){
        Post post =  postService.create(newPost);

        String userId =  post.getAuthor().getId();
        User author =  userRepository.findById(userId).get();

        author.getPosts().add(post);
        userRepository.save(author);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        Map<String, Object> objectResp =  new HashMap<>();
        objectResp.put("post", new PostDTO(post));
        objectResp.put("message", "Post criado com sucesso");


        return ResponseEntity.created(uri).body(objectResp);
    }


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
