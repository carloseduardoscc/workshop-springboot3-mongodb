package com.carloseduardo.workshopmongodb.services;

import com.carloseduardo.workshopmongodb.domain.Post;
import com.carloseduardo.workshopmongodb.repository.PostRepository;
import com.carloseduardo.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> opt = repo.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Post insert(Post post) {
        return repo.insert(post);
    }

    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        repo.deleteById(id);
    }

    public void update(Post postData, String id) {
        Post post = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(post, postData);
        repo.save(post);
    }

    private void updateData(Post post, Post postData) {
        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());
        post.setAuthor(postData.getAuthor());
        post.setDate(postData.getDate());
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
