package com.example.SpringMongoDb.resources;

import com.example.SpringMongoDb.Service.UserService;
import com.example.SpringMongoDb.domain.User;
import com.example.SpringMongoDb.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = new ArrayList<>();
        for(User x : list)
            listDto.add(new UserDTO(x));
        return ResponseEntity.ok().body(listDto);
    }

}
