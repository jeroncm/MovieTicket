package com.demo.final_check;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	       registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:4200");
}
}
