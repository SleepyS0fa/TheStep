package ru.sleepySofa.term.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import ru.sleepySofa.term.models.Lecture;
import ru.sleepySofa.term.models.Term;
import ru.sleepySofa.term.services.GroupService;

import java.util.ArrayList;
import java.util.List;
@Component
public class MultiValueMapToLectureConverter implements Converter<MultiValueMap<String, Object>, Lecture> {

    @Autowired
    GroupService groupService;
    @Override
    public Lecture convert(MultiValueMap<String, Object> map) {
        Lecture lecture = new Lecture();
        lecture.setTitle((String) map.getFirst("title"));
        lecture.setText((String) map.getFirst("text"));
        lecture.setGroups(new ArrayList<>());
        if (map.get("groups") != null) {
            for (Object group : map.get("groups")) {
                lecture.getGroups().add(groupService.getGroupByName((String) group));
            }
        }
        lecture.setTerms(new ArrayList<>());
        List<Object> termName = map.get("term");
        List<Object> termDef = map.get("def");
        if (termName != null || termDef != null || termDef.size() != termName.size())
            for(int i = 0; i < termName.size(); i++) {
                lecture.getTerms().add(new Term(null, (String) termName.get(i), (String) termDef.get(i)));
            }
        return lecture;
    }

}
