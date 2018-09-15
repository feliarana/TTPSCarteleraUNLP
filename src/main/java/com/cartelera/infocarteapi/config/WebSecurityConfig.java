package com.cartelera.infocarteapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity( debug = true )
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService customUserDetailsService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(customUserDetailsService)
      .passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
  }

  /**
   * See: https://github.com/spring-projects/spring-boot/issues/11136
   *
   * @return
   * @throws Exception
   */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}