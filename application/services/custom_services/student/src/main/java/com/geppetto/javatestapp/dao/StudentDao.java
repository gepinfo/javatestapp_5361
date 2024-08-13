package com.geppetto.javatestapp.dao;

import com.geppetto.javatestapp.model.Student;
import java.util.List;
import java.util.Optional;


public interface StudentDao {

    Student create(Student student);


    Optional<Student> getEntityById(String id);


    List<Student> getAllValues();


    Optional<Student> update(String id);


    void delete(String id);

}
