package com.univali.workshopmongo.resources;

import com.univali.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User pedro = new User("1", "Pedro Henrique", "pedro.henrique@gmail.com");
        User joao = new User("1", "João", "joao@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(pedro, joao));
        return ResponseEntity.ok().body(list);
    }
}
