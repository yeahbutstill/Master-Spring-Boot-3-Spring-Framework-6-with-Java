package com.yeahbutstill.controller;

import com.yeahbutstill.bean.User;
import com.yeahbutstill.dao.UserDao;
import com.yeahbutstill.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserResource {

    private final UserDao userDao;

    @Autowired
    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDao.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable Long id) {
        User user = userDao.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createdUser(@RequestBody User user) {
        User savedUser = userDao.save(user);
        // this base url to mapping current request /users/6 => /users/{id} => user.getId
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
