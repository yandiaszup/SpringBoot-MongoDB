package com.example.SpringMongoDb.repository;

import com.example.SpringMongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //Classe do repositorio e tipo do id do objeto

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTittle(String text);


    List<Post> findByTitleContainingIgnoreCase(String text); //IgnoreCase -> Ignora se a palavra tem letras maiusculas ou não


    //https://docs.mongodb.com/manual/reference/operator/query/gte/
    @Query(" { $and: [  { 'date': {$gte: ?1} }, " +
                        "{ 'date': {$lte: ?2} }, " +
                        "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }," +
                                " { 'body': { $regex: ?0, $options: 'i' } }," +
                                " { 'comments.text': { $regex: ?0, $options: 'i' } }" +
                              " ] " +
                        "} " +
                    "] " +
            "}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
