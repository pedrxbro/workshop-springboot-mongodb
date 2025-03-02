package com.univali.workshopmongo.config;

import com.univali.workshopmongo.domain.Post;
import com.univali.workshopmongo.domain.User;
import com.univali.workshopmongo.repositories.PostRepository;
import com.univali.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User pedro = new User(null,"Pedro Henrique", "pedro@gmail.com");
        User amanda = new User(null,"Amanda", "amanda@gmail.com");
        User joao = new User(null,"João", "joao@gmail.com");

       Post post = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!", "Vou viajar para São Paulo. Abraços!", pedro);
       Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje!", pedro);

        userRepository.saveAll(Arrays.asList(pedro,amanda,joao));
        postRepository.saveAll(Arrays.asList(post,post2));
    }
}
