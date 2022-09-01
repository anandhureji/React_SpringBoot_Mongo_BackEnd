package net.javaguides.SpringMongoDb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@PostMapping("/todos")
	public ResponseEntity<?> createTodos(@RequestBody TodoDto todos)
	{
		try {
			todos.setCreatedAt(new Date(System.currentTimeMillis()));
			repositiory.save(todos);
			return new ResponseEntity<TodoDto>(todos,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<?> getSingleTodos(@PathVariable("id") String id)
	{
		Optional<TodoDto> todoOptional =repositiory.findById(id);
		if(todoOptional.isPresent())
		{
			return new ResponseEntity<>(todoOptional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Todo not found with id "+id,HttpStatus.NOT_FOUND);
		}
		
	}

}
