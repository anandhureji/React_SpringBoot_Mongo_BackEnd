package net.javaguides.SpringMongoDb.models;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class TodoDto {
	
	@Id
	private String id;
	private String todo;
	private String description;
	private Boolean completed;
	private Date createdAt;
	private Date updatedAt;

}
