package com.example.springMentoring.security;

import com.example.springMentoring.dao.UserRepository;
import com.example.springMentoring.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);

        SecurityUser securityUser = user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("user doesn't exist"));
        return securityUser;
    }
}
