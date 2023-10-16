package com.example.demo.taller1proyecto.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password(passwordEncoder().encode("798fa90d-ab66-45d6-812f-67451a301c74")).roles("USER").build());

    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults()).authorizeHttpRequests(authConfig -> {
            authConfig.anyRequest().authenticated();
        }).httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * @Bean public SecurityFilterChain applicationSecurity(HttpSecurity http)
     *       throws Exception {
     *       http.cors().disable().csrf().disable().sessionManagement()
     *       .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().formLogin().disable().securityMatcher("/")
     *       .authorizeHttpRequests(registry ->
     *       registry.requestMatchers("/").permitAll()); return http.build();
     * 
     *       }
     **/
}