package com.example.SpringMongoDb.repository;

import com.example.SpringMongoDb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { //Classe do repositorio e tipo do id do objeto

}
