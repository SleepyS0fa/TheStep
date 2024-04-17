package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(username);
        if (userDetails != null) {
            return userDetails;
        }
        userDetails = userRepository.findByUsername(username);
        if (userDetails != null) {
            return userDetails;
        }
        return new Account() {
        };
    }

}
