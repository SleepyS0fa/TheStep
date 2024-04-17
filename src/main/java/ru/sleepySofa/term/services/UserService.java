package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.users.Account;
import ru.sleepySofa.term.models.enums.Role;
import ru.sleepySofa.term.repositories.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    private static boolean firstAdmin = true;
    public boolean createAccount(Account client) {
        if (firstAdmin) {
            client.setActive(true);
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            client.getRoles().add(Role.ROLE_ADMIN);
            userRepository.save(client);
            firstAdmin = false;
            return true;
        }

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

    public boolean saveAccount(Account client) {
        try {
            userRepository.save(client);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean changePass(Account user, String pass) {
        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
        return true;
    }

    public Account getUserByPrinciple(Principal principal) {
        if (principal == null) return null;
        return userRepository.findByUsername(principal.getName());
    }
    public Account addRoleAdmin(Account client) {
        if (userRepository.findByUsername(client.getUsername()) == null ||
                userRepository.findByEmail(client.getEmail()) == null) {
            return null;
        }
        client.getRoles().add(Role.ROLE_ADMIN);
        return client;
    }

    public List<Account> listAll() {
        return (List<Account>) userRepository.findAll();
    }

    public Account getUserById (Long id) {
        Optional<Account> user = userRepository.findById(id);
        return user.orElse(new Account());
    }

    public boolean changeEmail(Account user, String email) {
        try {
            user.setEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
