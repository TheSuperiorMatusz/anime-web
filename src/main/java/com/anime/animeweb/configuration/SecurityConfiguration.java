package com.anime.animeweb.configuration;

import com.anime.animeweb.configuration.infrastructure.CorsConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CorsConfigProperties corsConfigProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/api/v1/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigProperties() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(corsConfigProperties.getAllowCredentials());
        configuration.setAllowedMethods(corsConfigProperties.getAllowedMethods());
        configuration.setAllowedOrigins(corsConfigProperties.getAllowedOrigins());
        configuration.setExposedHeaders(corsConfigProperties.getExposedHeaders());
        configuration.setAllowedOrigins(corsConfigProperties.getAllowedOrigins());
        configuration.setMaxAge(corsConfigProperties.getMaxAge());

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
