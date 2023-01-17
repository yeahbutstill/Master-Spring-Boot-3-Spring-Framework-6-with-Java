package com.yeahbutstill.controller;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.service.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@SessionAttributes("name")
public class TodoController {

    private final TodoServiceImpl todoService;

    @Autowired
    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername("yeahbutstill");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping(value = "/add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        Todo todo = new Todo(1L, username, "Please edit this description", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @PostMapping(value = "/add-todo")
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String username = (String) modelMap.get("username");
        todoService.addTodo(username,  todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @GetMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam Long id) {
        todoService.deleteById(id);
        return "redirect:/list-todos";
    }

    @GetMapping(value = "/update-todo")
    public String showUpdateTodoPage(@RequestParam @Valid Long id, ModelMap modelMap) {
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping(value = "/update-todo")
    public String updateTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String username = (String) modelMap.get("username");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
