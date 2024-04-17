package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.models.users.Account;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByAuthor(Account author);
    List<Lecture> findByTitle(String title);
}
