package org.gtr3base.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public JwtUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //if there will be db we`ll fetch user from db
        if("user".equals(username)){
            return new User("user",
                    passwordEncoder.encode("password"),
                    new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
