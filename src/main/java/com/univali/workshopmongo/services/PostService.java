package com.univali.workshopmongo.services;

import com.univali.workshopmongo.domain.Post;
import com.univali.workshopmongo.repositories.PostRepository;
import com.univali.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Post post = repo.findById(id).orElse(null);
        if(post == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return post;
    }


}
