package com.cartelera.infocarteapi.service;

import com.cartelera.infocarteapi.model.User;
import com.cartelera.infocarteapi.model.UserDetailsImpl;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByUsername(userName);
    return Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
      .map(UserDetailsImpl::new).get();
  }

  @Autowired
  private UserRepository repo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void save(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    repo.save(user);
  }

}