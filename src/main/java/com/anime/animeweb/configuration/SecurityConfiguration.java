package com.anime.animeweb.configuration;

import com.anime.animeweb.configuration.filter.JwtAuthFilter;
import com.anime.animeweb.configuration.infrastructure.CorsConfigProperties;
import com.anime.animeweb.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthFilter authFilter;
    private final CorsConfigProperties corsConfigProperties;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationProvider authenticationProvider = this.authenticationProvide();
        return http.
                authorizeHttpRequests((authorizeRequests) -> authorizeRequests.requestMatchers("/api/v1/users/register", "/api/v1/users/generateToken").permitAll()
                        .requestMatchers("/api/v1/animes/**", "/api/v1/studios/**", "/api/v1/reviews/**", "/api/v1/comments/**")
                        .authenticated())
                .httpBasic(withDefaults()).csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

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


    public AuthenticationProvider authenticationProvide() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(this.userService);
        authenticationProvider.setPasswordEncoder(this.passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
