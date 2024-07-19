package com.carloseduardo.workshopmongodb.configuration;

import com.carloseduardo.workshopmongodb.domain.Post;
import com.carloseduardo.workshopmongodb.domain.User;
import com.carloseduardo.workshopmongodb.dto.AuthorDTO;
import com.carloseduardo.workshopmongodb.dto.CommentDTO;
import com.carloseduardo.workshopmongodb.repository.PostRepository;
import com.carloseduardo.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Gray", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viajem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }

}
