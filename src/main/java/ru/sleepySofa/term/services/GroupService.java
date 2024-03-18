package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.repositories.GroupRepository;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {
    @Autowired
    private final GroupRepository groupRepository;
    public List<Group> getGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    public boolean saveGroup(Group group) {
        log.info("Saving new {}", group);
        groupRepository.save(group);
        return true;
    }

    public Group getGroupByName(String name) {
        return groupRepository.findByName(name).iterator().next();
    }
}
