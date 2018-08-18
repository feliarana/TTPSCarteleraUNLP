package com.cartelera.infocarteapi;

import com.cartelera.infocarteapi.entities.Billboard;
import com.cartelera.infocarteapi.entities.Role;
import com.cartelera.infocarteapi.entities.User;
import com.cartelera.infocarteapi.repository.BillboardRepository;
import com.cartelera.infocarteapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class  InfocarteApiApplication {

    @Autowired
    private BillboardRepository billboardRepo;

    @Component
    class DataSetup implements ApplicationRunner{
        @Override
        public void run(ApplicationArguments run) throws Exception{
          billboardRepo.save(Billboard.builder().title("Cartelera Principal").build());
          billboardRepo.save(Billboard.builder().title("1ero").build());
          billboardRepo.save(Billboard.builder().title("2do").build());
          billboardRepo.save(Billboard.builder().title("3ero").build());
          billboardRepo.save(Billboard.builder().title("4to").build());
          billboardRepo.save(Billboard.builder().title("5to").build());
          billboardRepo.save(Billboard.builder().title("Oportunidades").build());
          billboardRepo.save(Billboard.builder().title("Otros").build());
        }
    }

  @Bean
  public CommandLineRunner setupDefaultUser(UserService service) {
    return args -> {
      service.save(new User(
        "root", //username
        "root", //password
        Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
        true//Active
      ));
    };
  }

  @Bean
  public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  public static void main(String[] args) {
    SpringApplication.run(InfocarteApiApplication.class, args);
  }
}
