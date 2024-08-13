package com.geppetto.javatestapp.dao.daoimpl;

import com.geppetto.javatestapp.model.User;
import com.geppetto.javatestapp.repository.UserRepository;
import com.geppetto.javatestapp.dao.UserDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    private final UserRepository userRepository;

     public UserDaoImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
}





}
