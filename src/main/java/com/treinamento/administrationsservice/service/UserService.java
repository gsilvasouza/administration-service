package com.treinamento.administrationsservice.service;

import com.treinamento.administrationsservice.entity.User;
import com.treinamento.administrationsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    //Function to find all users;
    public List<User> findAll(){
        return repo.findAll();
    }

    //Function to find user by id
    public User findById(Integer id) throws Exception {
        Optional<User> userExisted = this.repo.findById(id);
        if(userExisted.isPresent()){
            return userExisted.get();
        }else{
            throw new Exception("User not Found");
        }
    }

}
