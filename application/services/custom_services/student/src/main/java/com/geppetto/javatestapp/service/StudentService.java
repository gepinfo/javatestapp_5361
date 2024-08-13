package com.geppetto.javatestapp.service;

import com.geppetto.javatestapp.dto.StudentDto;
import java.util.List;
import java.util.Map;

public interface StudentService {

    StudentDto create(StudentDto studentDto);


    StudentDto getEntityById(String id);


    List<StudentDto> getAllValues();


    StudentDto update(StudentDto studentDto);


    String delete(String id);



}
