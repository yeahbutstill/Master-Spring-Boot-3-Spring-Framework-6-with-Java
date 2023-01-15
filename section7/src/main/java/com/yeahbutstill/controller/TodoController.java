package com.yeahbutstill.controller;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.service.impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoServiceImpl todoService;

    @Autowired
    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername("yeahbutstill");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage() {
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@RequestParam String description, ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
        return "redirect:/list-todos";
    }

}
