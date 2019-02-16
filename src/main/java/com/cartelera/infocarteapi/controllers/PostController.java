package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.repository.BillboardRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/api/billboards")
public class PostController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BillboardRepository billboardRepository;

  private static final Logger logger = LoggerFactory.getLogger(PostController.class);

}
