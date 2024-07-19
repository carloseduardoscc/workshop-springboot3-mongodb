package com.carloseduardo.workshopmongodb.repository;

import com.carloseduardo.workshopmongodb.domain.Post;
import com.carloseduardo.workshopmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
