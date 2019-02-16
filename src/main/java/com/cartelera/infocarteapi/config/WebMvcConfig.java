package com.cartelera.infocarteapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final long MAX_AGE_SECS = 3600;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PATCH", "DELETE")
      .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
        "Access-Control-Request-Headers")
      .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
      .maxAge(MAX_AGE_SECS);
  }


}
