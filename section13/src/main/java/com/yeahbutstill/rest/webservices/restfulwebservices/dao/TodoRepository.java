package com.yeahbutstill.rest.webservices.restfulwebservices.dao;

import com.yeahbutstill.rest.webservices.restfulwebservices.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUsername(String username);

}
