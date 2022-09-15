package net.javaguides.SpringMongoDb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.SpringMongoDb.models.Employees;

import net.javaguides.SpringMongoDb.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody Employees employees)
	{
		try
		{
			employeeRepo.save(employees);
			return new ResponseEntity<Employees>(employees,HttpStatus.OK);
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployee()
	{
		List<Employees> findAll = employeeRepo.findAll();
		if(findAll.size()>0)
		{
			return new ResponseEntity<List<Employees>>(findAll,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("No Employees Available",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id)
	{
		Optional<Employees> byId = employeeRepo.findById(id);
		if(byId.isPresent())
		{
			return new ResponseEntity<>(byId.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employeedel/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") String id)
	{
		employeeRepo.deleteById(id);
		return new ResponseEntity<>("deleted",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/employees")
	public Employees updateEmployee(@RequestBody Employees employees)
	{
		return employeeRepo.save(employees);
	}

}
