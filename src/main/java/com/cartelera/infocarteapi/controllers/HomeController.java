package com.cartelera.infocarteapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

  @GetMapping(value = "/")
  public String home(){
    return "Hola home";
  }

  @GetMapping(value = "/perfil")
  public String backend(){
    return "Hola back";
  }

}
