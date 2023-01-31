package com.yeahbutstill.rest.webservices.restfulwebservices.service;

import com.yeahbutstill.rest.webservices.restfulwebservices.pojo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "yeahbutstill","Get AWS Certified",
							LocalDate.now().plusYears(10), false ));
		todos.add(new Todo(++todosCount, "yeahbutstill","Learn DevOps",
				LocalDate.now().plusYears(11), false ));
		todos.add(new Todo(++todosCount, "yeahbutstill","Learn Full Stack Development",
				LocalDate.now().plusYears(12), false ));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}