package com.chat.chatApp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chat.chatApp.model.Users;

public interface UsersRepository extends MongoRepository<Users, String>{

}
