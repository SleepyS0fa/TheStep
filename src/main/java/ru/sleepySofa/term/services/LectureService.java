package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.repositories.LectureRepository;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureService {
    @Autowired
    private final LectureRepository lectureRepository;

    public List<Lecture> listAll() {
        return (List<Lecture>) lectureRepository.findAll();
    }

//    public List<Lecture> listForGroup(String group) {
//        return lectureRepository.findByGroups(group);
//    }

    public boolean saveLecture(Lecture lecture) {
        log.info("Saving new {}", lecture);
        lectureRepository.save(lecture);
        return true;
    }

    public boolean deleteLecture(Long id) {
        log.info("Deleting {}", id);
        lectureRepository.deleteById(id);
        return true;
    }

    public List<Lecture> getLecturesByAuthor(String author) {
        log.info("Getting by author{}", author);
        List<Lecture> lectures = lectureRepository.findByAuthor(author);
        if (lectures == null) {
            return listAll();
        }
        return lectures;
    }
    public List<Lecture> getLecturesByTitle(String title) {
        log.info("Getting by author{}", title);
        List<Lecture> lectures = lectureRepository.findByTitle(title);
        if (lectures == null) {
            return listAll();
        }
        return lectures;
    }

    public Lecture getLectureById(Long id) {
        log.info("Getting {}", id);
        return lectureRepository.findById(id).orElse(null);
    }
}
