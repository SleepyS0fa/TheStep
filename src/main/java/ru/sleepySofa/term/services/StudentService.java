package ru.sleepySofa.term.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.users.Student;
import ru.sleepySofa.term.repositories.StudentRepository;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public boolean saveStudent(Student student) {
        log.info("Saving new {}", student);
        studentRepository.save(student);
        return true;
    }
}
