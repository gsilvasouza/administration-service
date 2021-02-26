package com.treinamento.administrationsservice.controller;

import com.treinamento.administrationsservice.entity.User;
import com.treinamento.administrationsservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserControlller {
    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() throws Exception {
        List<User> users = this.service.findAll();
        if (users == null) {
            System.out.println("Entrou aqui");
            throw new Exception("Usuarios nao encontardos");
        } else {
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) throws Exception {
        User user = this.service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
