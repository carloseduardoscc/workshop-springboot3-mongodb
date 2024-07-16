package com.carloseduardo.workshopmongodb.resources;

import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.dto.UserDTO;
import com.carloseduardo.workshopmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

}
