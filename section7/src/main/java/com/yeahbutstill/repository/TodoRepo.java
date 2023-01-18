package com.yeahbutstill.repository;

import com.yeahbutstill.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

    List<Todo> findByUsername(String username);

}
