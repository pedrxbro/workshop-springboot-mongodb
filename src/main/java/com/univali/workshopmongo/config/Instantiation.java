package com.univali.workshopmongo.config;

import com.univali.workshopmongo.domain.User;
import com.univali.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pedro = new User(null,"Pedro Henrique", "pedro@gmail.com");
        User amanda = new User(null,"Amanda", "amanda@gmail.com");
        User joao = new User(null,"João", "joao@gmail.com");

        userRepository.saveAll(Arrays.asList(pedro,amanda,joao));
    }
}
