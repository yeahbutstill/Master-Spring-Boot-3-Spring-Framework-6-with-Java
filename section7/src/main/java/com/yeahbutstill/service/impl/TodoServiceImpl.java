package com.yeahbutstill.service.impl;

import com.yeahbutstill.entity.Todo;
import com.yeahbutstill.service.TodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1L, "yeahbutstill", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1L, "yeahbutstill", "Learn DevOps", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1L, "yeahbutstill", "Learn Vault", LocalDate.now().plusYears(1), false));
    }

    @Override
    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
