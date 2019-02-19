package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.payload.JwtAuthenticationResponse;
import com.cartelera.infocarteapi.payload.LoginRequest;
import com.cartelera.infocarteapi.repository.RoleRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import com.cartelera.infocarteapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtTokenProvider tokenProvider;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid LoginRequest loginRequest) throws UnsupportedEncodingException {

    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginRequest.getUsername(),
        loginRequest.getPassword()
      )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
  }

//  @RequestMapping(value= "/**", method= RequestMethod.OPTIONS)
//  public void corsHeaders(HttpServletResponse response) {
//    response.addHeader("Access-Control-Allow-Origin", "*");
//    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//    response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
//    response.addHeader("Access-Control-Max-Age", "3600");
//  }
}
