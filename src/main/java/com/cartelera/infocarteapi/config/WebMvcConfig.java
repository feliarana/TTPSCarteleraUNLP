package com.cartelera.infocarteapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("GET", "POST", "DELETE", "HEAD", "OPTIONS")
      .allowedOrigins("*")
      .allowedHeaders("*");
    //    registry.addMapping("/**").allowedMethods("GET", "POST", "DELETE", "HEAD", "OPTIONS")
//      .allowedOrigins("*")
//      .allowedHeaders("Permission", "Cache-Control", "Content-Type", "Accept", "X-Requested-With", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
//      .exposedHeaders("Access-Control-Expose-Headers", "Permission", "Cache-Control", "Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin");
  }


}
