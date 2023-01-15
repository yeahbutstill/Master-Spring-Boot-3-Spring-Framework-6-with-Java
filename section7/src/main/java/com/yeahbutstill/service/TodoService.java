package com.yeahbutstill.service;

import com.yeahbutstill.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findByUsername(String username);
}
