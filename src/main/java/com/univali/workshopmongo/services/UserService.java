package com.univali.workshopmongo.services;

import com.univali.workshopmongo.domain.User;
import com.univali.workshopmongo.dto.UserDTO;
import com.univali.workshopmongo.repositories.UserRepository;
import com.univali.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    public User findById(String id){
        User user = repo.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return user;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElse(null);
        updateData(newObj, obj);
        return repo.save(newObj);

    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

 }
