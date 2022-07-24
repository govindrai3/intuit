package com.chat.chatApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chatApp.model.Users;
import com.chat.chatApp.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Users Controller")
@RestController
@RequestMapping("/chat-users")
public class UsersController {
	
@Autowired
UserService userService;


@ApiOperation("Creating a new user")	
@PostMapping("/user")
public ResponseEntity<Users> createUser(@RequestBody Users user)
{
	Users createdUser=userService.createUser(user);
	return new ResponseEntity<Users>(createdUser, HttpStatus.CREATED);
	
}

@ApiOperation("Listing of users")	
@GetMapping("/users")
public ResponseEntity<List<Users>> getAllUsers()
{
	return new ResponseEntity<List<Users>>(userService.getAllUsers(), HttpStatus.OK);	
}
	

}
