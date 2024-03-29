package ru.sleepySofa.term.models.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.sleepySofa.term.models.Group;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "student")
public class Student extends Account {
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;
}
