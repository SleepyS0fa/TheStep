package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.users.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
