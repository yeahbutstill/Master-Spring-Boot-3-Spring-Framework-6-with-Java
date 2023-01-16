package com.yeahbutstill.service.impl;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.service.TodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class TodoServiceImpl implements TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static Long todosCount = 0L;

    static {
        todos.add(new Todo(++todosCount, "yeahbutstill", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "yeahbutstill", "Learn DevOps", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "yeahbutstill", "Learn Vault", LocalDate.now().plusYears(1), false));
    }

    @Override
    public List<Todo> findByUsername(String username) {
        return todos;
    }

    @Override
    public void addTodo(String username, String description, LocalDate target, Boolean done) {
        Todo todo = new Todo(++todosCount, username, description, target, done);
        todos.add(todo);
    }

    @Override
    public void deleteById(Long id) {
        // Lamba func programming
        Predicate<? super Todo> predicate = todo -> Objects.equals(todo.getId(), id);
        todos.removeIf(predicate);
    }

}
