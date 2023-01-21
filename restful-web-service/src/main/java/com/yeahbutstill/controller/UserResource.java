package com.yeahbutstill.controller;

import com.yeahbutstill.dao.UserDao;
import com.yeahbutstill.entity.User;
import com.yeahbutstill.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<User> retrieveUser(@Valid @PathVariable Long id) {
        User user = userDao.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .retrieveAllUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));

        return userEntityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createdUser(@Valid @RequestBody User user) {
        User savedUser = userDao.save(user);
        // this base url to mapping current request /users/6 => /users/{id} => user.getId
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@Valid @PathVariable Long id) {
        userDao.deleteById(id);
    }

}
