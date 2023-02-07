package com.yeahbutstill.controller;

import com.yeahbutstill.dto.Todo;
import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path = "/todos")
    public List<Todo> retrieveAllTodos() {
        return getTodos();
    }

    @GetMapping(path = "/users/{username}/todos")
    // Jagoan gua
    @PreAuthorize(value = "hasRole('USER_BU') and #username == authentication.name")
    // Jagoan gua
    @PostAuthorize(value = "returnObject.username() == authentication.name")

    // Diff
    @RolesAllowed({"ADMIN", "USER_BU"})
    @Secured({"ROLE_ADMIN", "ROLE_USER_BU"})
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
                new Todo("yeahbutstill", "Get AWS Certified"),
                new Todo("admin", "Admin Todo Nih"),
                new Todo("admin.ics", "Admin ICS Todo Nih"),

                new Todo("ics.gssk05", "Learn AWS"),
                new Todo("ics.gssk05", "Get AWS Certified"),
                new Todo("ics.gssk05", "Admin Todo Nih"),
                new Todo("ics.gssk05", "Admin ICS Todo Nih")
        );
    }

}
