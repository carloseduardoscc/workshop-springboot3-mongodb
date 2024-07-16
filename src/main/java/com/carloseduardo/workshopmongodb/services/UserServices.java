package com.carloseduardo.workshopmongodb.services;

import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.dto.UserDTO;
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

    public User insert (User user){
        return repo.insert(user);
    }

    public User fromDTO (UserDTO userDTO){
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }

    public void delete (String id){
        if (!repo.existsById(id)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        repo.deleteById(id);
    }

}
