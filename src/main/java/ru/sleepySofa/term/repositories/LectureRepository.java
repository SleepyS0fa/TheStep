package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.Lecture;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByAuthor(String author);
//    List<Lecture> findByGroups(String groups);
    List<Lecture> findByTitle(String title);
}
