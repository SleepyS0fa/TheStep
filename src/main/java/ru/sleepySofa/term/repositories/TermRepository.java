package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.Term;

public interface TermRepository extends CrudRepository<Term, Long> {
}
