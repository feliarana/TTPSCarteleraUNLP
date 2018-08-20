package com.cartelera.infocarteapi.service;

import com.cartelera.infocarteapi.entities.User;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void save(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    repo.save(user);
  }

}