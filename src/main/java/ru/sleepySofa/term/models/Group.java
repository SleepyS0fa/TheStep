package ru.sleepySofa.term.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sleepySofa.term.models.users.Student;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Student> students = new ArrayList<>();
    @ToString.Exclude
    @ManyToMany(mappedBy = "groups")
    private List<Lecture> lectures = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
        student.setGroup(this);
    }
    public void removeStudent(Student student){
        this.students.remove(student);
        student.setGroup(null);
    }
}
