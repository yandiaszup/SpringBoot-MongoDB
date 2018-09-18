package com.example.SpringMongoDb.resources;

import com.example.SpringMongoDb.Service.PostService;
import com.example.SpringMongoDb.Service.UserService;
import com.example.SpringMongoDb.domain.Post;
import com.example.SpringMongoDb.domain.User;
import com.example.SpringMongoDb.dto.UserDTO;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
