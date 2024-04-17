package ru.sleepySofa.term.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import ru.sleepySofa.term.models.users.Account;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lectures")
public class Lecture implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Account author;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Group> groups;
    @Column(name = "title")
    private String title;
    @Column(name = "text", columnDefinition = "text")
    private String text;
    @Column(name = "terms")
    @OneToMany(fetch = FetchType.EAGER)
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Term> terms;

    public void addGroup(Group group){
        this.groups.add(group);
        group.getLectures().add(this);
    }
    public void removeGroup(Group group){
        this.groups.remove(group);
        group.getLectures().remove(this);
    }

//    public void addTerm(Term term){
//        this.terms.add(term);
//        term.setLecture(this);
//    }
//    public void removeTerm(Term term){
//        this.terms.remove(term);
//        term.setLecture(this);
//    }
}



