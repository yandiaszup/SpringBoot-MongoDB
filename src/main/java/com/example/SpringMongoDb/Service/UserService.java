package com.example.SpringMongoDb.Service;

import com.example.SpringMongoDb.Service.exception.ObjectNotFoundException;
import com.example.SpringMongoDb.domain.User;
import com.example.SpringMongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
}
