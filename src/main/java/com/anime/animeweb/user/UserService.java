package com.anime.animeweb.user;

import com.anime.animeweb.core.EntityRepository;
import com.anime.animeweb.core.EntityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends EntityService<User> implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    public UserService(EntityRepository<User> repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = ((UserRepository) this.repository).findByLogin(username);
    }

    @Override
    public User addEntityToDatabase(User entity) {
        return super.addEntityToDatabase(entity);
    }


}
