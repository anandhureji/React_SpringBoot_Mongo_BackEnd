package net.javaguides.SpringMongoDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.SpringMongoDb.models.TodoDto;
import net.javaguides.SpringMongoDb.repository.TodoRepositiory;

@RestController
public class TodoController {
	
	
	@Autowired
	private TodoRepositiory repositiory;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodos()
	{
		List<TodoDto> todos = repositiory.findAll();
		if(todos.size()>0)
		{
			return new ResponseEntity<List<TodoDto>>(todos,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("No Todos available",HttpStatus.NOT_FOUND);
		}
	}
	

}
