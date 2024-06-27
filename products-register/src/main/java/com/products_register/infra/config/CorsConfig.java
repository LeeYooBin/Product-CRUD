package com.products_register.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings("null")
@Configuration
public class CorsConfig {
  @Bean
  WebMvcConfigurer corsConfigurer() {
  return new WebMvcConfigurer() {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
              .allowedOrigins("*")
              .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
              .allowedHeaders("*")
              .allowCredentials(false);
    }
  };
}
}
