package com.geppetto.javatestapp.service.serviceimpl;

import com.geppetto.javatestapp.dao.StudentDao;
import com.geppetto.javatestapp.model.Student;
import com.geppetto.javatestapp.dto.StudentDto;
import com.geppetto.javatestapp.service.StudentService;
import com.geppetto.javatestapp.exception.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

      private final StudentDao studentDao;

      private final MongoTemplate mongoTemplate;
      public StudentServiceImpl(StudentDao  studentDao,MongoTemplate mongoTemplate) {
          this. studentDao =  studentDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public StudentDto create(StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        Student createdStudent= studentDao.create(student);
        BeanUtils.copyProperties(createdStudent, studentDto);
        return studentDto;
    }


    @Override
    public StudentDto getEntityById(String id) {
    StudentDto studentDto = new StudentDto();
    Optional<Student> result = studentDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), studentDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return studentDto;
    }


    @Override
    public List<StudentDto> getAllValues() {
        List<Student> studentEntities = studentDao.getAllValues();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student studentEntity : studentEntities) {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(studentEntity, studentDto);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }



    @Override
    public StudentDto update(StudentDto studentDto) {
    Optional<Student> result = studentDao.update(studentDto.get_id());
        if (result.isPresent()) {
           Student student = result.get();
           BeanUtils.copyProperties(studentDto, student);
           studentDao.create(student);
           return studentDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + studentDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Student> result = studentDao.getEntityById(id);
        if (result.isPresent()) {
            studentDao.delete(id);
        }else{
        throw new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete.");
        }
        return "Data Deleted Successfully";
    }



    private String constructQuery(Map<String, String> params) {
       StringBuilder queryBuilder = new StringBuilder("{ ");
         for (Map.Entry<String, String> entry : params.entrySet()) {
         queryBuilder.append(entry.getKey()).append(": '").append(entry.getValue()).append("', ");
    }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()).append(" }");
        return queryBuilder.toString();
    }
}