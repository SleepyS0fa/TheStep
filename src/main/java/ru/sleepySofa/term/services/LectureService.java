package ru.sleepySofa.term.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.sleepySofa.term.models.Lecture;

import java.util.*;

@Service
public class LectureService {
    private final List<Lecture> lectures = new ArrayList<>();
    private long ID = 0;
    @Getter
    private final List<String> groups = new ArrayList<>();
    {
        groups.add("KK-182");
        groups.add("КС-191");
        groups.add("ИБ-202");
        groups.add("БД-231");
        groups.add("ИБ-201");
        lectures.add(new Lecture(++ID,"Sofa",new ArrayList<>(),"text1","Some text",new ArrayList<>(),new ArrayList<>()));
        lectures.add(new Lecture(++ID,"Sofa",new ArrayList<>(),"text2","Text num2",new ArrayList<>(),new ArrayList<>()));
        lectures.add(new Lecture(++ID,"Sofa",new ArrayList<>(),"text3","And last text",new ArrayList<>(),new ArrayList<>()));

    }

    public List<Lecture> listAll() {
        return lectures;
    }

    public List<Lecture> listForGroup(String group) {
        List<Lecture> listForGroup = new ArrayList<>();
        for (Lecture lecture : lectures) {
            if (lecture.getGroups().contains(group))
                listForGroup.add(lecture);
        }
        return listForGroup;
    }

    public boolean saveLecture(Lecture lecture) {
        try {
            lecture.setId(++ID);
            lectures.add(lecture);
            System.out.println(lecture);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteLecture(Long id) {
        try {
            lectures.removeIf(lecture -> lecture.getId().equals(id));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Lecture> getLecturesByAuthor(String author) {
        List<Lecture> lecturesList = new ArrayList<>();
        for (Lecture lecture: lectures) {
            if (lecture.getAuthor().equals(author)) {
                lecturesList.add(lecture);
            }
        }
        return lecturesList.isEmpty()? null : lecturesList;
    }

    public Lecture getLectureById(Long id) {
        for(Lecture lecture: lectures) {
            if (lecture.getId().equals(id)) {
                return lecture;
            }
        }
        return null;
    }
}
