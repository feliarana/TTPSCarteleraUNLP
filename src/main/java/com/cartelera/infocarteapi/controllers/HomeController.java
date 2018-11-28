package com.cartelera.infocarteapi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  //publico
  @RequestMapping("/index")
  public String home(){
    return "Hola index";
  }

  //necesita ser admin  secured endpoint — An ADMIN can access this endpoint with valid user credentials.
  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping("/admin")
  @ResponseBody
  public String adminBackend(){
    return "Hola admin";
  }

  //publico
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  @RequestMapping("/user")
  @ResponseBody

  public String userBackend(){
    return "Hola usuario";
  }

}
