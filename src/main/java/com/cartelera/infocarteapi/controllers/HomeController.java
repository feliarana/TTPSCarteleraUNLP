package com.cartelera.infocarteapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping("/index")
  public String home(){
    return "Hola index";
  }

  @RequestMapping("/admin")
  public String adminBackend(){
    return "Hola admin";
  }

  @RequestMapping("/user")
  public String userBackend(){
    return "Hola usuario";
  }

}
