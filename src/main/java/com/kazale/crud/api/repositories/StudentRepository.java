package com.kazale.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kazale.crud.api.documents.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
