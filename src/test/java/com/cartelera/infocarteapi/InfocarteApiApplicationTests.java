package com.cartelera.infocarteapi;

import com.cartelera.infocarteapi.repository.BillboardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfocarteApiApplicationTests {

  @Autowired
  private BillboardRepository billboardRepo;

  @Test
  public void contextLoads() {
  }


  @Test
  public void obtainBillboards() {
    assertNotNull(billboardRepo.findAll());
  }
}
