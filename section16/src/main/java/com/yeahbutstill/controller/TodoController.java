package com.yeahbutstill.controller;

import com.yeahbutstill.dto.Todo;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path = "/todos")
    public List<Todo> retrieveAllTodos() {
        return getTodos();
    }

    @GetMapping(path = "/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return getTodos().get(0);
    }

    @PostMapping(path = "/users/{username}/todos")
    public void creatTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

    @GetMapping(path = "/csrf-token")
    public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    private static List<Todo> getTodos() {
        return List.of(new Todo("yeahbutstill", "Learn AWS"),
                new Todo("yeahbutstill", "Get AWS Certified")
        );
    }

}
