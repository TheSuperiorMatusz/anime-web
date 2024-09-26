package com.anime.animeweb.user;

import com.anime.animeweb.configuration.authorization.AuthorizationRequest;
import com.anime.animeweb.configuration.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        return userService.addEntityToDatabase(user);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthorizationRequest authorizationRequest) {
        String token = null;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authorizationRequest.getLogin(), authorizationRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            token = jwtService.generateToken(authorizationRequest.getLogin());
        }
        return token;
    }
}
