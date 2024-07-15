package com.carloseduardo.workshopmongodb.services;

import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.repository.UserRepository;
import com.carloseduardo.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> opt = repo.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
