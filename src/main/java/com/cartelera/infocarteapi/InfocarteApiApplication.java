package com.cartelera.infocarteapi;

import com.cartelera.infocarteapi.exception.AppException;
import com.cartelera.infocarteapi.model.Role;
import com.cartelera.infocarteapi.model.User;
import com.cartelera.infocarteapi.repository.RoleRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
  InfocarteApiApplication.class,
  Jsr310JpaConverters.class
})
public class InfocarteApiApplication {

  @PostConstruct
  void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }


  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  public static void main(String[] args) {
    SpringApplication.run(InfocarteApiApplication.class, args);
  }
}

