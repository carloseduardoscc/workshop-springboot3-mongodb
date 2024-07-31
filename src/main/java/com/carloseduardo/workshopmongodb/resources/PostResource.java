package com.carloseduardo.workshopmongodb.resources;

import com.carloseduardo.workshopmongodb.domain.Post;
import com.carloseduardo.workshopmongodb.resources.util.URL;
import com.carloseduardo.workshopmongodb.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll() {
        List<Post> postList = service.findAll();
        return ResponseEntity.ok(postList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Post post){
        Post insertedPost = service.insert(post);
        URI insertedPostURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertedPost.getId()).toUri();
        return ResponseEntity.created(insertedPostURI).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Post post, @PathVariable String id){
        service.update(post, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam("text") String text) {
        text = URL.decodeParam(text);
        List<Post> searchedPosts = service.findByTitle(text);
        return ResponseEntity.ok(searchedPosts);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> posts = service.fullSearch(text, min, max);
        return ResponseEntity.ok(posts);

    }

}
