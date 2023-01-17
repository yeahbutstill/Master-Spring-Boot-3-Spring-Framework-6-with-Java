package com.yeahbutstill.service;

import com.yeahbutstill.entity.Todo;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {

    List<Todo> findByUsername(String username);
    void addTodo(String username, String description, LocalDate target, Boolean done);
    void deleteById(Long id);
    Todo findById(Long id);
    void updateTodo(Todo todo);

}
