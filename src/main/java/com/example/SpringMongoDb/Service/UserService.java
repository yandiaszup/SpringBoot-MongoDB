package com.example.SpringMongoDb.Service;

import com.example.SpringMongoDb.domain.User;
import com.example.SpringMongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
