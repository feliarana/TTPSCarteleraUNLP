package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.exception.AppException;
import com.cartelera.infocarteapi.model.Role;
import com.cartelera.infocarteapi.model.User;
import com.cartelera.infocarteapi.payload.ApiResponse;
import com.cartelera.infocarteapi.payload.JwtAuthenticationResponse;
import com.cartelera.infocarteapi.payload.LoginRequest;
import com.cartelera.infocarteapi.payload.SignUpRequest;
import com.cartelera.infocarteapi.repository.RoleRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import com.cartelera.infocarteapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Collections;

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

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid SignUpRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
        HttpStatus.BAD_REQUEST);
    }

    // Creating user's account
//      User user = new User(signUpRequest.getUsername(),signUpRequest.getPassword(), true);
    Role userRole = roleRepository.findByRoleName("ROLE_USER")
      .orElseThrow(() -> new AppException("User Role not set."));

    User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()), Collections.singleton(userRole), true);


    user.setRoles(Collections.singleton(userRole));

    User result = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
      .fromCurrentContextPath().path("/users/{username}")
      .buildAndExpand(result.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
  }
}
