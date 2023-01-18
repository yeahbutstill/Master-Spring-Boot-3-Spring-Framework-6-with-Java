package com.yeahbutstill.controller;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.repository.TodoRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {

    private final TodoRepo todoRepo;

    @Autowired
    public TodoControllerJpa(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @GetMapping(value = "/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        List<Todo> todos = todoRepo.findByUsername(username);
        modelMap.addAttribute("todos", todos);

        return "listTodos";
    }

    @GetMapping(value = "/add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        Todo todo = new Todo(1L, username, "Please edit this description", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);

        return "todo";
    }

    @PostMapping(value = "/add-todo")
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername(modelMap);
        todo.setUsername(username);
        todoRepo.save(todo);

        return "redirect:/list-todos";
    }

    @GetMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam Long id) {
        todoRepo.deleteById(id);

        return "redirect:/list-todos";
    }

    @GetMapping(value = "/update-todo")
    public String showUpdateTodoPage(@RequestParam @Valid Long id, ModelMap modelMap) {
        Todo todo = todoRepo.findById(id).orElse(new Todo());
        modelMap.addAttribute("todo", todo);

        return "todo";
    }

    @PostMapping(value = "/update-todo")
    public String updateTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername(modelMap);
        todo.setUsername(username);
        todoRepo.save(todo);

        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        modelMap.getAttribute(authentication.getName());

        return authentication.getName();
    }

}
