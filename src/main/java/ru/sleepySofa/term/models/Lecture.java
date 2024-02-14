package ru.sleepySofa.term.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class Lecture {
    private Long id;
    private String author;
    private List<String> groups;
    private String title;
    private String text;
    private List<String> terms;
    private List<String> def;

}
