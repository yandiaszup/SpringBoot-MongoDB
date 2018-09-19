package com.example.SpringMongoDb.repository;

import com.example.SpringMongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //Classe do repositorio e tipo do id do objeto

    List<Post> findByTitleContainingIgnoreCase(String text); //IgnoreCase -> Ignora se a palavra tem letras maiusculas ou não
}
