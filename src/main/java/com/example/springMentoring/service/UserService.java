package com.example.springMentoring.service;

import com.example.springMentoring.dao.UserRepository;
import com.example.springMentoring.model.User;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("user [%s] doesn't exist.", login)));
    }
}
