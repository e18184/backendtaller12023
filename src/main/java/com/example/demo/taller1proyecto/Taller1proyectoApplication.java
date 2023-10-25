package com.example.demo.taller1proyecto;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Taller1proyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taller1proyectoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:9000"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "DELETE", "POST", "OPTIONS", "PUT", "PATCH"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		corsConfiguration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(new CorsFilter(source));
		registrationBean.setOrder(0); // You can set the order as needed
		return registrationBean;
	}
}
