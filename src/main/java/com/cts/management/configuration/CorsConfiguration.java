package com.cts.management.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfiguration {
    public WebMvcConfigurer corsConfigurer(){
         final String GET="GET";
         final String POST ="POST";
         final String DELETE ="DELETE";
        final String PUT ="PUT";
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**")
                        .allowedMethods(GET,POST,DELETE,PUT)
                        .allowedHeaders("*")
                        .allowedOrigins("http://localhost:4200")
                        .allowCredentials(true)
                        ;
            }
        };
    }
}
