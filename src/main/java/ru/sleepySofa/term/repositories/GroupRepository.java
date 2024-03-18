package ru.sleepySofa.term.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.Lecture;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findByName(String name);
}
