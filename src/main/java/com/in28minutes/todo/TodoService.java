package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static{
		todos.add(new Todo(1, "mustafa", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "mustafa", "Learn Hibernate", new Date(), false));
		todos.add(new Todo(3, "mustafa", "Learn Tomcat", new Date(), false));
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone){
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public boolean deleteTodo(int id){
		boolean success = false;
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()){
			Todo todo = iterator.next();
			if(todo.getId() == id){
				iterator.remove();
				success = true;
			}
		}
		return success;
	}
	
	public List<Todo> retriveTodos(String user){
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for(Todo todo : todos){
			if(todo.getName().equals(user)){
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public Todo retrieveTodo(int id){
		for(Todo todo : todos){
			if(todo.getId() == id){
				return todo;
			}
		}
		return null;
	}
	
	public void updateTodo(Todo todo){
		todos.remove(todo);
		todos.add(todo);
	}
}
