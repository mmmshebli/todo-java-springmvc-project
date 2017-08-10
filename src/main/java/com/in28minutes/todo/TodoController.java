package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model){
		model.addAttribute("todos", todoService.retriveTodos(retriveLoggedinUsername()));
		return "list-todos";
	}

	private String retriveLoggedinUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model){
		model.addAttribute(new Todo(0, retriveLoggedinUsername(), "default description", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodo(@Valid Todo todo, BindingResult result){
		if(result.hasErrors()){
			return "todo";
		}
		todoService.addTodo(todo.getName() , todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, Todo todo){
		Todo selected = todoService.retrieveTodo(todo.getId());
		model.addAttribute(selected);
		
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()){
			return "todo";
		}
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(ModelMap model, @RequestParam int id){
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
}
