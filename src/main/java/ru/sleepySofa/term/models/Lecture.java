package ru.sleepySofa.term.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lectures")
public class Lecture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "author")
    private String author;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Group> groups;
    @Column(name = "title")
    private String title;
    @Column(name = "text", columnDefinition = "text")
    private String text;
    @Column(name = "terms")
    private List<String> terms;
    @Column(name = "def")
    private List<String> def;
}



