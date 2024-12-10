package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pawpengaga.model.User;
import com.pawpengaga.repository.UserRepository;

public class UserService {

  @Autowired
  UserRepository userRepo;

  public List<User> getAllUsers(){
    return userRepo.findAll();
  }

  public int createUser(User userInput){
    return userRepo.save(userInput);
  }

}
