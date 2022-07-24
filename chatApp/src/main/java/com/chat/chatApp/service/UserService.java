package com.chat.chatApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.chat.chatApp.model.Users;
import com.chat.chatApp.repo.UsersRepository;

@Service
public class UserService {
	
@Autowired
UsersRepository userRepo;
	
@Autowired
private MongoOperations mongo;
	
	
public Users createUser(Users user)
{
	return userRepo.save(user);
}


public List<Users> getAllUsers()
{
	return userRepo.findAll();
}



public String getNextSequence(String seqName)
{
    Users counter = mongo.findAndModify(
        query(where("_id").is(seqName)),
        new Update().inc("seq",1),
        options().returnNew(true).upsert(true),
        Users.class);
    return counter.getId();
}

}
