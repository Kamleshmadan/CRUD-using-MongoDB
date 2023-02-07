package com.mongoDB.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoDB.CRUD.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {

}
