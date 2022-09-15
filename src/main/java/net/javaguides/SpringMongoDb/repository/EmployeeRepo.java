package net.javaguides.SpringMongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.SpringMongoDb.models.Employees;

@Repository
public interface EmployeeRepo extends MongoRepository<Employees, String> {

}
