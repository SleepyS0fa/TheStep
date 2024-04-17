package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.users.Account;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByEmail(String email);

    Optional<Account> findById(Long id);
}
