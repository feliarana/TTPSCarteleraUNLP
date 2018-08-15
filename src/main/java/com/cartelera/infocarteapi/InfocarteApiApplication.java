package com.cartelera.infocarteapi;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.repository.BillboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

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

    public static void main(String[] args) {
        SpringApplication.run(InfocarteApiApplication.class, args);
    }
}
