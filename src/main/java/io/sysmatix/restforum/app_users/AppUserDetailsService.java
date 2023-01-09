package io.sysmatix.restforum.app_users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser appUser = repository.findByEmailAddress(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User
            .withUsername(appUser.getEmailAddress())
            .password(appUser.getHashedPassword())
            .authorities("USER")
            .build();
        return user;
    }
}
