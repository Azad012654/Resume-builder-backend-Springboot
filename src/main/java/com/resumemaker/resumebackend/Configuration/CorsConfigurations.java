//package com.resumemaker.resumebackend.Configuration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfigurations implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("https://my-first-resume-app.netlify.app") // Replace with your frontend origin(s)
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Add any other HTTP methods you want to allow
//                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept") // Add any other headers you want to allow
//                .allowCredentials(true); // Set this to true if you need to allow credentials (e.g., cookies) from the client-side
//    }
//}
//
