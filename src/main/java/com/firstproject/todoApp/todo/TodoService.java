package com.firstproject.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todosCount=0;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++todosCount, "in28Minutes", "Learn AWS", LocalDate.now().plusMonths(5), false));
		todos.add(new Todo(++todosCount, "CodeCamp", "Learn JAVA", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "selfLearn", "Learn FullStack Develoment", LocalDate.now().plusYears(2), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getusername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
