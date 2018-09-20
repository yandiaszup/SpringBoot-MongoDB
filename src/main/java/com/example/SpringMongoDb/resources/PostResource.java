package com.example.SpringMongoDb.resources;

import com.example.SpringMongoDb.Service.PostService;
import com.example.SpringMongoDb.Service.UserService;
import com.example.SpringMongoDb.domain.Post;
import com.example.SpringMongoDb.domain.User;
import com.example.SpringMongoDb.dto.UserDTO;
import com.example.SpringMongoDb.resources.util.URL;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullsearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L)); // data padrão
        Date max = URL.convertDate(minDate, new Date()); // data atual do sistema

        List<Post> list = postService.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }


}
