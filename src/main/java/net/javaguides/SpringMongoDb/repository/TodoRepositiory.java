package net.javaguides.SpringMongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.SpringMongoDb.models.TodoDto;

@Repository
public interface TodoRepositiory extends MongoRepository<TodoDto, String> {
	

}
