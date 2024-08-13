package com.geppetto.javatestapp.repository;

import com.geppetto.javatestapp.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>  {

}
