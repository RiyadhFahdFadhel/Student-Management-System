package com.example.studentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    // In-memory login user: admin/password
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User
            .withUsername("admin")
            .password("{noop}password")  // {noop} = plaintext (no encoding)
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(admin);
    }

    // Define which URLs are public and which require login
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // optional: disables CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index.html", "/dashboard.html", "/frontend/**").permitAll()
                .requestMatchers("/api/**", "/admin.html").authenticated()
            )
            .formLogin(); // default Spring Boot login page
        return http.build();
    }
}
