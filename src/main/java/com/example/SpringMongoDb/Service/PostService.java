package com.example.SpringMongoDb.Service;

import com.example.SpringMongoDb.Service.exception.ObjectNotFoundException;
import com.example.SpringMongoDb.domain.Post;
import com.example.SpringMongoDb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTittle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }

}
