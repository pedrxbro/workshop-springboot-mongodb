package com.univali.workshopmongo.repositories;

import com.univali.workshopmongo.domain.Post;
import com.univali.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
