package com.geppetto.javatestapp.repository;

import com.geppetto.javatestapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>  {

}
