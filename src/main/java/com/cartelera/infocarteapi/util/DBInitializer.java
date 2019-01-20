package com.cartelera.infocarteapi.util;

import com.cartelera.infocarteapi.model.Role;
import com.cartelera.infocarteapi.model.User;
import com.cartelera.infocarteapi.repository.RoleRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class DBInitializer {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

    public void initialize(){
      Role userRole = new Role ();
      userRole.setRoleName("ROLE_ADMIN");
      roleRepository.save(userRole);
//      User admin = new User ("admin", passwordEncoder.encode("123456"), Collections.singleton(userRole), true);
//      userRepository.save(admin);

    }
}
