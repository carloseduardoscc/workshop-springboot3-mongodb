package com.carloseduardo.workshopmongodb.resources;

import com.carloseduardo.workshopmongodb.domain.Post;
import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.dto.UserDTO;
import com.carloseduardo.workshopmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> userList = service.findAll();
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok(userDTOList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody User user){
        User insertedUser = service.insert(user);
        URI insertedUserURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertedUser.getId()).toUri();
        return ResponseEntity.created(insertedUserURI).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user, @PathVariable String id){
        service.update(user, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts(@PathVariable String id) {
        User user = service.findById(id);
        List<Post> posts = user.getPosts();
        return ResponseEntity.ok(posts);
    }
}
