package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.models.enums.Role;
import ru.sleepySofa.term.repositories.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public boolean createAccount(Account client) {
        if (userRepository.findByUsername(client.getUsername()) != null ||
            userRepository.findByEmail(client.getEmail()) != null) {
            return false;
        }
        client.setActive(true);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.getRoles().add(Role.ROLE_USER);
        userRepository.save(client);
        return true;
    }

    public boolean addRoleAdmin(Account client) {
        if (userRepository.findByUsername(client.getUsername()) == null ||
                userRepository.findByEmail(client.getEmail()) == null) {
            return false;
        }
        client.getRoles().add(Role.ROLE_ADMIN);
        return true;
    }
}
