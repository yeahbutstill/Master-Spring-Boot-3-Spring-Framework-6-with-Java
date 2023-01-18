package com.yeahbutstill.service.impl;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.service.TodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoServiceImpl implements TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static Long todosCount = 1L;

    static {
        todos.add(new Todo(todosCount++, "yeahbutstill", "Learn AWS 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "yeahbutstill", "Learn DevOps 2", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todosCount++, "yeahbutstill", "Learn Vault 3", LocalDate.now().plusYears(3), false));
    }

    @Override
    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    @Override
    public void addTodo(String username, String description, LocalDate target, Boolean done) {
        Todo todo = new Todo(todosCount++, username, description, target, done);
        todos.add(todo);
    }

    @Override
    public void deleteById(Long id) {
        // Lamba func programming
        Predicate<? super Todo> predicate = todo -> todo.getId().equals(id);
        todos.removeIf(predicate);
    }

    @Override
    public Todo findById(Long id) {
        Predicate<? super Todo> predicate = todo -> todo.getId().equals(id);
        return todos.stream().filter(predicate).findFirst().orElseGet(Todo::new);
    }

    @Override
    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

}
