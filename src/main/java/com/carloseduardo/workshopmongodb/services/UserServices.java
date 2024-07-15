package com.carloseduardo.workshopmongodb.services;

import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

}
