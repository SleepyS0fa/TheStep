package ru.sleepySofa.term.models.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.sleepySofa.term.models.Group;
import ru.sleepySofa.term.models.User;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "student")
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;
}
