package com.yeahbutstill.controller;

import com.yeahbutstill.entity.Posting;
import com.yeahbutstill.entity.User;
import com.yeahbutstill.exception.UserNotFoundException;
import com.yeahbutstill.repository.PostingRepository;
import com.yeahbutstill.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/jpa/users")
public class UserJPAResource {

    private static final String ACTION_USER_NOT_FOUND = "UserNotFoundException id: ";
    private final UserRepository userRepository;
    private final PostingRepository postingRepository;

    @Autowired
    public UserJPAResource(UserRepository userRepository, PostingRepository postingRepository) {
        this.userRepository = userRepository;
        this.postingRepository = postingRepository;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUser(@Valid @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(ACTION_USER_NOT_FOUND + id);
        }

        EntityModel<User> userEntityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .retrieveAllUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));

        return userEntityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createdUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        // this base url to mapping current request /users/6 => /users/{id} => user.getId
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@Valid @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(ACTION_USER_NOT_FOUND + id);
        }
        userRepository.deleteById(id);
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Posting> retrivePostingForUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(ACTION_USER_NOT_FOUND + id);
        }

        return user.get().getPostings();
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> createPostingForUser(@PathVariable Long id, @Valid @RequestBody Posting posting) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(ACTION_USER_NOT_FOUND + id);
        }

        posting.setUser(user.get());
        Posting savedPost = postingRepository.save(posting);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
