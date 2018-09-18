package com.example.SpringMongoDb.repository;

import com.example.SpringMongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //Classe do repositorio e tipo do id do objeto

}
